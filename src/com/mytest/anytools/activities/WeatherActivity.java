package com.mytest.anytools.activities;

import com.mytest.anytools.bean.WebServiceParams;

import android.app.Activity;
import android.os.Bundle;

public class WeatherActivity extends Activity{

	private static String CLASS_NAME;
	private WebServiceParams weatherWebServiceParam;
	
	public WeatherActivity()
	{
		CLASS_NAME = getClass().getName();
		
		weatherWebServiceParam = new WebServiceParams();
		weatherWebServiceParam.setNameSpace("http://WebXml.com.cn/");
		weatherWebServiceParam.setMethodName("getSutCity");
		weatherWebServiceParam.setMethodParams(new String[]{"byProvinceName"});
		weatherWebServiceParam.setServiceUrl("http://www.webxml.com.cn/webservices/weatherwebservice.asmx");

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		
		
	}
	
}
