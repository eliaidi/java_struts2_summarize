package com.wt.entity;

/**
 *  @author hohoTT
 * 	1. Department ��ģ�ͣ�ʵ��¼��� Department��deptName ����ֱ��д��
 * 	s:textfield �� name �����У�manager ����Ӧ����δ���
 * 
 * 		Struts2 ����ǩ�� name ��ֵ���Ա�ӳ�䵽(��Ϊ)һ�����Ե����ԣ�
 * 			name = manager.name, name = manager.birth
 * 
 *  2. manager ����һ�� Date ���͵� birth ���ԣ�Struts2 ��������Զ���������
 *  
 * 	ȫ�ֵ�����ת�������������Ĺ���
 *
 */

public class Department {
	
	private Integer id;
	private String deptName;

	private Manager manager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", manager="
				+ manager + "]";
	}
	
}
