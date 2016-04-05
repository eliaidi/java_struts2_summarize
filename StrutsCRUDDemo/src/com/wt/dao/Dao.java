package com.wt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wt.entity.Employee;

public class Dao {
	
	private static Map<Integer, Employee> emps = new HashMap<Integer, Employee>();
	
	// 静态代码块进行 emps 的初始化
	static{
		
		emps.put(1001, new Employee(1001, "AA", "aa", "aa@hohoTT.com"));
		emps.put(1002, new Employee(1002, "BB", "bb", "bb@hohoTT.com"));
		emps.put(1003, new Employee(1003, "CC", "cc", "cc@hohoTT.com"));
		emps.put(1004, new Employee(1004, "DD", "dd", "dd@hohoTT.com"));
		emps.put(1005, new Employee(1005, "EE", "ee", "ee@hohoTT.com"));
		
	}
	
	// 获取所有的 employee
	public List<Employee> geteEmployees(){
		
		return new ArrayList<>(emps.values());
		
	}
	
	// 删除操作
	public void delete(Integer empId){
		
		emps.remove(empId);
		
	}
	
	// 添加操作
	public void save(Employee employee){
		
		long time = System.currentTimeMillis();
		employee.setEmployeeId((int)time);
		
		emps.put(employee.getEmployeeId(), employee);
		
	}
	
	// 获取employee
	public Employee get(Integer empID){
		
		return emps.get(empID);
		
	}
	
	// 修改操作
	public void update(Employee employee){
		
		emps.put(employee.getEmployeeId(), employee);
		
	}

}
