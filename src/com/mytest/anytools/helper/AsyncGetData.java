package com.mytest.anytools.helper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.mytest.anytools.bean.WebServiceParams;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class AsyncGetData extends AsyncTask<WebServiceParams, Integer, String>
{
	private static String CLASS_NAME;
	private final int GET_REPONSE_FAIL = -1;
	private final int GET_REPONSE_SUCC = 1;
	private final int GET_REPONSE_NULL = 2;
	
	private int resultCode;
	private Handler mHandler;
	
	public final static String RESULT = "result";
	
	public AsyncGetData(Handler handler)
	{
		CLASS_NAME = getClass().getName();
		mHandler = handler;
	}
	
	@Override
	protected String doInBackground(WebServiceParams... params) {
		
		String reponse = null;
		
		String nameSpace = params[0].getNameSpace();
		String methodName = params[0].getMethodName();
		String methodParamNames[] = params[0].getMethodParamNames();
		Object methodParams[] = params[0].getMethodParams();
		String serviceUrl = params[0].getServiceUrl();
		
		//创建webService结构体
		SoapObject request = new SoapObject(nameSpace, methodName);
		
		//设置调用方法需要传入的参数
		if (null != methodParamNames && null != methodParams)
		{
			for (int i = 0; i < methodParamNames.length; i++)
			{
				request.addProperty(methodParamNames[i], methodParams[i]);
				//Log.i(CLASS_NAME, "methodParamNames[" + i + "]:" + methodParamNames[i] + ", value:" + methodParams[i].toString());
			}
		}

		//生成调用webService方法的SOAP请求信息，并指定SOAP的版本
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.bodyOut = request;
		envelope.setOutputSoapObject(request);
		
		HttpTransportSE transport = new HttpTransportSE(serviceUrl);
		transport.debug = true;
		
		try {
			transport.call(nameSpace + methodName, envelope);

			if (null != envelope.getResponse())
			{
				Log.i(CLASS_NAME, "response: " + envelope.getResponse());
				resultCode = GET_REPONSE_SUCC;
				reponse = envelope.getResponse().toString();
			}
			else
			{
				Log.w(CLASS_NAME, "get reponse is null!!");
				resultCode = GET_REPONSE_NULL;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Log.w(CLASS_NAME, "get reponse failed!!");
			resultCode = GET_REPONSE_FAIL;
		}
		
		return reponse;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {

		
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(String result) {
		if (GET_REPONSE_SUCC == resultCode && null != mHandler)
		{
			Message msg = mHandler.obtainMessage();
			
			Bundle data = new Bundle();
			data.putString(RESULT, result);
			msg.setData(data);
			
			mHandler.sendMessage(msg);
		}
		
		super.onPostExecute(result);
	}
	
}

