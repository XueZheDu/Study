package com.gnkjxy.demo2.homework6;

public class Homework6 {
	public static void main(String[] args) {
		//测试Dog类
		Dog dog1 = new Dog("小黄", "黄色", 5);
		dog1.show();
		
		//测试Music类
		Music mus1 = new Music("Tot Musica", 195);
		mus1.play();
		System.out.println(mus1.getInfo());
		
		//11.在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的
		//定义形式，调用语句为:System.out.println(method(method(10.0,20.0),100));
		System.out.println(method(method(10.0,20.0),100));
		
		//测试Employee类
		Employee emp1 = new Employee("jack", "男", 34, "java工程师", "23k");
		System.out.println(emp1.name + " " + emp1.gender + " " + emp1.age + " " 
				+ emp1.job + " " + emp1.salary);
		Employee emp2 = new Employee("小王", "男", 24);
		System.out.println(emp2.name + " " + emp2.gender + " " + emp2.age + " " 
				+ emp2.job + " " + emp2.salary);
		Employee emp3 = new Employee("厨师", "22k");
		System.out.println(emp3.name + " " + emp3.gender + " " + emp3.age + " " 
				+ emp3.job + " " + emp3.salary);
		
	}
	
	static double method(double num1, double num2) {
		return 1;
	}
	
}
