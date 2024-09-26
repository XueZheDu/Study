package com.gnkjxy.demo2.cloneObject;

public class CloneObject {
	public static void main(String[] args) {
		/*
		编写一个方法copyPerson， 可以复制一个Person 对象，返回复制的对象。
		克隆对象，注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
		
		 */
		Person p = new Person();
		p.name = "milan";
		p.age = 100;
		
		MyTools tool = new MyTools();
		Person p2 = tool.copyPerson(p);
		
		System.out.println("p.name = " + p.name + " p1.age = " + p.age);
		System.out.println("p2.name = " + p2.name + " p2.age = " + p2.age);
		//System.out.println(p == p);
		System.out.println(p == p2);
		
	}
}

class Person {
	String name;
	int age;
}

class MyTools {
	public Person copyPerson(Person p) {
		Person p2 = new Person();
		p2.name = p.name;
		p2.age = p.age;
		return p2;
	}
}