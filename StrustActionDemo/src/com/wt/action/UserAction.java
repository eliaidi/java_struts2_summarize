package com.wt.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware{
	
	public String execute(){
		
		// 把用户信息存入 Session 域中
		// 1. 获取 session，通过实现 SessionAware 接口
		
		// 2. 获取登录信息
		
		// 3. 把用户信息存入 Session 域中
		
		// 在线人数 +1
		
		return "success";
	}
	
	/**
	 * 
	 */
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
