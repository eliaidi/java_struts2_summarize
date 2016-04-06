package com.wt.action;

import java.util.Arrays;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class TestI18nAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 创建一个栈顶的属性
	private Date date = null;

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String execute() throws Exception {
		
		// 初始化 date
		date = new Date();
		
		// 1. 在 Action 中访问国际化资源文件的 value 值
		
		String username = getText("username");
		System.out.println("username ---- " + username);
		
		// 2. 以下为获取带占位符的数值
		String time = getText("time", Arrays.asList(date));
		System.out.println("time ---- " + time);
		

		return SUCCESS;
	}
	
	
}
