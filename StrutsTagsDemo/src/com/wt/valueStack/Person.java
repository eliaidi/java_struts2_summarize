package com.wt.valueStack;

public class Person {

	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// 无参构造器
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	// 带参的构造器
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
