package com.gnkjxy.demo2.homework6;

/*
	7.设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。 
	并创建对像，进行测试、【提示this.属性】

 */

public class Dog {
	String name;
	String colour;
	int age;
	
	public Dog(String name, String colour, int age) {
		this.name = name;
		this.colour = colour;
		this.age = age;
	}
	
	public void show() {
		System.out.println("名字：" + this.name + "\n颜色：" + this.colour
				+ "\n年龄：" + this.age);
	}
}
