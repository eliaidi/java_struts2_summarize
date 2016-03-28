package com.wt.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


/**
 * 
 * @author hohoTT
 * ServletActionContext: ���Դ��л�ȡ��ǰ Action ������Ҫ��һ�� Servlet API ��صĶ���
 * ���õķ�����
 * 1. ��ȡ HttpServletRequest :  ServletActionContext.getRequest()
 * 2. ��ȡ HttpSession : ServletActionContext.getRequest().getSession()
 * 3. ��ȡ ServletContext : ServletActionContext.getServletContext()
 *
 */
public class TestServletActionContextAction {

	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
//		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpSession session = request.getSession();
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		System.out.println("------execute------");
		
		
		return "success";
	}
	
}
