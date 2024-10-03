package com.gnkjxy.demo2.homework5;

public class Homework5 {
	public static void main(String[] args) {
		//测试max
		double[] arr1 = {3.2, 5.6, -1.2, 7.6, 2.8};
		A01 a1 = new A01();
		Double res = a1.max(arr1);
		if(res != null) {
			System.out.println("double数组arr1的最大值为" + res);
		} else {
			System.out.println("数组输入有误");
		}
		
		//测试find
		String[] arr2 = {"hello", "world", "java"};
		A02 a2 = new A02();
		int res1 = a2.find("world", arr2);
		if(res1 != -1) {
			System.out.println("找到了，下标为" + res1);
		} else {
			System.out.println("没找到");
		}
		
		//测试updatePrice
		Book book1 = new Book("笑傲江湖", 300);
		book1.info();
		book1.updatePrice();
		book1.info();
		
		//测试copyArr
		A03 a3 = new A03();
		int[] arr3 = {1, 2, 3};
		int[] arr3New = a3.copyArr(arr3);
		for(int i = 0; i < arr3New.length; i++) {
			System.out.print(arr3New[i] + " ");
		}
		System.out.println();
		
		char[] arr4 = {'a', 'b', 'c', 'd'};
		char[] arr4New = a3.copyArr(arr4);
		for(int i = 0; i < arr4New.length; i++) {
			System.out.print(arr4New[i] + " ");
		}
		System.out.println();
		
		double[] arr5 = {1.0, 2.0, 3.0};
		double[] arr5New = a3.copyArr(arr5);
		for(int i = 0; i < arr5New.length; i++) {
			System.out.print(arr5New[i] + " ");
		}
		System.out.println();
		
		//测试Circle
		Circle cir1 = new Circle();
		cir1.radius = 1;
		cir1.showPerimeter();
		cir1.showArea();
		
		//测试Cale
		Cale cal1 = new Cale();
		cal1.num1 = 2;
		cal1.num2 = 10;
		System.out.println("两数之和为" + cal1.sum());
		System.out.println("两数之差为" + cal1.sub());
		System.out.println("两数之积为" + cal1.mul());
		System.out.println("两数之商为" + cal1.div());
		
		Cale cal2 = new Cale();
		cal2.num1 = 2;
		cal2.num2 = 0;
		System.out.println(cal2.div());
		
	}
}

//1.编写类A01,定义方法max，实现求某个double数组的最大值，并返回
class A01 {
	public Double max(double[] arr) {
		//代码健壮性
		//先判断 arr != null, 防止空指针调用
		if(arr != null && arr.length > 0) {
			double maxNum = arr[0];
			for(int i = 1; i < arr.length; i++) {
				if(maxNum < arr[i]) {
					maxNum = arr[i];
				}
			}
			return maxNum;
		} else {
			return null;
		}
		
	}
}

////2.编写类A02,定义方法find，实现查找某字符串数组中的元素查找，并返回素引
//如果找不到，返回-1
class A02 {
	public int find(String findStr, String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(findStr.equals(arr[i])) {
				return i;
			}
		}
		
		return -1;
	}
}

//3.编写类Book，定义方法updatePrice，实现更改某本书的价格，具体:如果价格>150.
//则更改为150，如果价格>100.更改为100，否则不变
class Book {
	String name;
	double price;
	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public void updatePrice() {
		if(this.price > 150) {
			this.price = 150;
		} else if(this.price > 100) {
			this.price = 100;
		}
	}
	public void info() {
		System.out.println("书名=" + this.name + "价格=" + this.price);
	}
}

//4.编写类A03.实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
class A03 {
	//copyArr 元素类型为 int
	public int[] copyArr(int[] arr) {
		int[] arrNew = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		return arrNew;
	}
	
	//copyArr 元素类型为 char
	public char[] copyArr(char[] arr) {
		char[] arrNew = new char[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		return arrNew;
	}
	
	//copyArr 元素类型为 double
	public double[] copyArr(double[] arr) {
		double[] arrNew = new double[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[i];
		}
		return arrNew;
	}
	
}

//5.定义一个圆类Circle，定义属性:半径，提供显示圆周长功能的方法，提供显示圆面积的方法
class Circle {
	double radius;
	
	public void showPerimeter() {
		System.out.println("圆的周长为" + (2 * Math.PI * radius));
	}
	
	public void showArea() {
		System.out.println("圆的面积为" + (Math.PI * radius * radius));
	}
}

//6.编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
//定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对像，分别测试
class Cale {
	double num1;
	double num2;
	
	public double sum() {
		return num1 + num2;
	}
	
	public double sub() {
		return num1 - num2;
	}
	
	public double mul() {
		return num1 * num2;
	}
	
	public Double div() {
		if(num2 != 0) {
			return num1 / num2;
		} else {
			System.out.println("除数不能为0");
			return null;
		}
	}
	
}


