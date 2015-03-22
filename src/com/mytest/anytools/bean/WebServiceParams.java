package com.mytest.anytools.bean;

public class WebServiceParams {
	
	private String nameSpace;
	
	private String methodName;
	
	private String[] methodParamNames;
	
	private Object[] methodParams;
	
	private String serviceUrl;

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String[] getMethodParamNames() {
		return methodParamNames;
	}

	public void setMethodParamNames(String[] methodParamNames) {
		this.methodParamNames = methodParamNames;
	}

	public Object[] getMethodParams() {
		return methodParams;
	}

	public void setMethodParams(Object[] methodParams) {
		this.methodParams = methodParams;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	

}
