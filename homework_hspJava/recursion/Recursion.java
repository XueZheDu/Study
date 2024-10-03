package com.gnkjxy.demo2.recursion;

public class Recursion {
	public static void main(String[] args) {
		T t1 = new T();
		int n = 7;
		int res = t1.fibonacci(n);
		if(res != -1) {
			System.out.println("当n=" + n + "时，对应的斐波那契数为" + res);
		}
		
		int day = 1;
		int peachNum = t1.Peache(day);
		if(peachNum != -1) {
			System.out.println("第" + day + "天共" + peachNum + "个桃子");
		}
		
	}
}

class T {
	/*
	请使用递归的方式求出斐波那契数1，1,2,3,5,8,13...给你一个整数n，求出它的值是多少
	思路分析
	1.当 n = 1 斐波那契数 是 1
	2.当 n = 2 斐波那契数 是 1
	3.当 n >= 3 斐波那契数 是 前两个数之和
	
	 */
	
	public int fibonacci(int n) {
		if(n >= 1) {
			if(n == 1 || n == 2) {
				return 1;
			} else {
				return fibonacci(n - 1) + fibonacci(n-2);
			}
		} else {
			System.out.println("要求输入的n为大于等于1的整数");
			return -1;
		}
	}
	
	/*
	猴子吃桃子问题:有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！ 
	以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时， 
	想再吃时(即还没吃)，发现只有1个桃子了。问题:最初共多少个桃子？
	思路分析
	day = 10  n = 1
	1.第10天桃子个数(还没吃)		1
	  第9天桃子个数(还没吃)		(1+1)*2
	  第8天桃子个数(还没吃)		( (1+1)*2 +1)*2
	  ...
	  第1天桃子个数(还没吃)		( 后一天桃子个数(还没吃) +1)*2
	  
	 */
	
	public int Peache(int day) {
		if(day == 10) {
			return 1;
		} else if(day >= 1 && day <= 9) {
			return ( Peache(day+1) +1)*2;
		} else {
			System.out.println("天数必须在1-10之间");
			return -1;
		}
	}
	
}
