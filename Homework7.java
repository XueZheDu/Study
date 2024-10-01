package com.gnkjxy.demo2.homework7;

public class Homework7 {
	public static void main(String[] args) {
		/*
		13.将对象作为参数传递给方法。 
		题目要求: 
		(1)定义一个Circle类，包含一个double型的radius属性代表圆的半径，一findArea()
		方法返回圆的面积。 
		(2)定义一个类PassObject，在类中定义一个方法printAreas(),该方法的定义如下: 
		public void printAreas(Circle c, int times) //方法签名
		(3)在printAreas方法中打印输出1到times之间的每个整数半径值， 以及对应的面积。 
		例如，times为5，则输出半径1，2,3,4,5,以及对应的圆面积。 
		(4)在main方法中调用printAreas()方法，调用完毕后输出当前半径值。
		 */
		Circle cir1 = new Circle();
		PassObject p1 = new PassObject();
		p1.printAreas(cir1, 5);
		
	}
}

class Circle {
	double radius;
	
	public double findArea() {
		return Math.PI * radius * radius;
	}
}

class PassObject {
	public void printAreas(Circle c, int times) { 
		System.out.println("Radius\tAreas");
		for(int i = 1; i <= times; i++) {
			c.radius = i;
			System.out.println(c.radius + "\t" + c.findArea());
		}
	}
}
