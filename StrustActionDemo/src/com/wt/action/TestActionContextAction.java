package com.wt.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	
	public String execute(){
		
		// 0. ��ȡ ActionContext ����
		// ActionContext �� Action �������Ķ��󣬿��Դ��л�ȡ���� Action ��Ҫ��һ����Ϣ
		
		ActionContext actionContext = ActionContext.getContext();
		
		// 1. ��ȡapplication ��Ӧ�� Map��������������һ������
		// ͨ������ ActionContext ����� getApplication() ��������ȡ application ����� Map ����
		Map<String, Object> applicationMap = actionContext.getApplication();
		applicationMap.put("applicationKey", "applicationValue");
		
		// ��ȡ����
		Object date = applicationMap.get("date");
		System.out.println("date ---- " + date);
		
		// 2. session
		Map<String, Object> sessionMap = actionContext.getSession();
		sessionMap.put("sessionKey", "sessionValue");
		System.out.println(sessionMap.getClass());
		
		if(sessionMap instanceof SessionMap){
			SessionMap sm = (SessionMap) sessionMap;
			sm.invalidate();
			System.out.println("session ʧЧ");
		}
		
		// 3. request
		// ActionContext �в�û���ṩ getRequest ��������ȡ request ��Ӧ�� Map
		// ��Ҫ�ֹ����� get ���������� request �ַ�������ȡ
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		
		// 4. ��ȡ���������Ӧ�� Map������ȡָ���Ĳ���ֵ
		// ����������������֣�ֵ�����������ֵ��Ӧ���ַ�������
		// ע��: 1. getParameters �ķ���ֵΪ Map<String, Object>��������Map<String, String[]>
		// 	    2. parameters ��� Mapֻ�ܶ�������д�����ݣ����д�����ݣ������������ǲ�������
		Map<String, Object> parametersMap = actionContext.getParameters();
		System.out.println(((String[])parametersMap.get("name"))[0]);
		
		parametersMap.put("age", 121);
		
		return "success";
	}

}