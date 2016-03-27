package com.wt.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware, SessionAware, RequestAware, 
ParameterAware{
	
	
	public String execute(){
		
		// 1. �� application �м���һ�����ԣ� applicationKey2 -- applicationValue2
		application.put("applicationKey2", "applicationValue2");
		
		// 2. �� application �ж�ȡһ������ date������ӡ
		System.out.println("application.get('date')---" + application.get("date"));
		
		return "success";
	}
	
	private Map<String, Object> application;

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}

}
