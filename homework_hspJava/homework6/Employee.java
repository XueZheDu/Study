package com.gnkjxy.demo2.homework6;

/*
	12.创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造
	方法，可以初始化(1)(名字，性别，年龄，职位，薪水)，(2)(名字，性别，年龄)，
	(3)(职位，薪水)，要求充分复用构造器

 */

public class Employee {
	String name;
	String gender;
	int age;
	String job;
	String salary;
	
	public Employee(String name, String gender, int age, 
			String job, String salary) {
		this(name, gender, age);
		this.job = job;
		this.salary = salary;
	}
	
	public Employee(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public Employee(String job, String salary) {
		this.job = job;
		this.salary = salary;
	}
	
}
