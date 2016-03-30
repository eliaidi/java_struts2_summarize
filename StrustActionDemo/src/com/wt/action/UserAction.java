package com.wt.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware, ApplicationAware{
	
	private String username;

	public void setUsername(String username) {
		this.username = username;
	}

	public String logout(){
		
		// 1. �������� - 1����ȡ���������������������� 0�� �� - 1
		Integer count = (Integer) appliction.get("count");
		if(count != null && count > 0){
			count--;
			appliction.put("count", count);
		}
		
		
		// 2. session ʧЧ: ǿתΪ SessionMap������ invalidate ����
		((SessionMap)session).invalidate();
		
		return "logout-success";
	}
	
	public String execute(){
		
		// ���û���Ϣ���� Session ����
		// 1. ��ȡ session��ͨ��ʵ�� SessionAware �ӿ�
		
		// 2. ��ȡ��¼��Ϣ: ͨ����Action������setter ����
		
		// 3. ���û���Ϣ���� Session ����
		session.put("username", username);
		
		// �������� +1
		// 1. ��ȡ��ǰ�������������� application �л�ȡ
		Integer count = (Integer) appliction.get("count");
		if(count == null){
			count = 0;
		}
		
		// 2. ʹ��ǰ���������� + 1
		count++;
		
		appliction.put("count", count);
		
		return "login-success";
	}
	
	/**
	 * @param session
	 */
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
		
	}

	private Map<String, Object> appliction;
	

	@Override
	public void setApplication(Map<String, Object> appliction) {

		this.appliction = appliction;
		
	}

}