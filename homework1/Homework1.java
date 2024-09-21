package com.gnkjxy.demo2.homework1;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		/*
		1.编程实现如下功能
		某人有100，000元，每经过一次路口，需要交费，规则如下:
		1)当现金>50000时，每次交5%
		2)当现金<=50000时，每次交1000
		编程计算该人可以经过多少次路口，要求:使用while break方式完成
		
		 */
		/*
		思路分析
		定义变量cash(现金),变量count(记录经过路口次数)
		while死循环，每次循环判断：
		1)当现金>50000时，每次交5%，剩下95%，次数加1
		2)当1000<=现金<=50000时，每次交1000，次数加1
		3)当现金<1000时，break跳出循环
		结束循环后打印次数
		
		 */
		
		double cash = 100000;
		int count = 0;
		while(true) {
			if(cash > 50000) {
				cash *= 0.95;
				count++;
			} else if(cash >= 1000){
				cash -= 1000;
				count++;
			}else {
				break;
			}
		}
		System.out.println("该人剩下cash = " + cash + "\n可以经过" + count + "次路口");
		
		//2.实现判断一个整数，属于哪个范围:大于0；小于0；等于0 
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数:)");
		int num = sc.nextInt();
		if(num > 0) {
			System.out.println(num + "大于0");
		} else if(num < 0) {
			System.out.println(num + "小于0");
		} else {
			System.out.println(num + "等于0");
		}
		
		//3.判断一个年份是否为闰年
		System.out.println("请输入一个年份:)");
		int year = sc.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "年是闰年");
		} else {
			System.out.println(year + "年不是闰年");
		}
		
		//4.判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方
		//和等于其本身。例如:153=1*1*1+3*3*3+5*5*5
		/*
		思路分析
		1.用Scanner对象接收一个三位数整数赋给num2
		2.求其个位数：geWei = num2 % 10 
		  十位数：shiWei = num2 / 10 % 10
		  百位数：baiWei = num2 / 100
		3.判断: num2 == geWei * geWei * geWei +
						shiWei * shiWei * shiWei +
						baiWei * baiWei * baiWei
		 */
		
		System.out.println("请输入一个三位数整数:)");
		int num2 = sc.nextInt();
		int geWei = 0, shiWei = 0, baiWei = 0;
		geWei = num2 % 10;
		shiWei = num2 / 10 % 10;
		baiWei = num2 / 100;
		if(num2 == geWei * geWei * geWei + 
				shiWei * shiWei * shiWei + 
				baiWei * baiWei * baiWei) {
			System.out.println(num2 + "是水仙花数");
		} else {
			System.out.println(num2 + "不是水仙花数");
		}
		
		//6.输出1-100之间的不能被5整除的数，每5个一行
		int count2 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 5 != 0) {
				System.out.print(i + " ");
				count2++;
				if(count2 % 5 == 0) {//每5个换一行
					System.out.println();
				}
			}
		}
		
		//7.输出小写的a-z以及大写的Z-A 
		//a-z
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		//Z-A
		for(char i = 'Z'; i >= 'A'; i--) {
			System.out.print(i + " ");
		}
		
		//8.求出1-1/2+1/3-1/4..1/100的和
		double sum = 0;
		//第一项可视为 1/1
		for(int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {//加上除数为奇数的项
				sum += 1.0 / i;
			} else {//减去除数为偶数的项
				sum -= 1.0 / i;
			}
		}
		System.out.println("1-1/2+1/3-1/4..1/100 = " + sum);
		
		//9.求1+(1+2)+(1+2+3)+(1+2+3+4)+…+(1+2+3+…+100)的结果
		int sum2 = 0;
		//括号外累加
		for(int i = 1; i <= 100; i++) {
			//括号内累加
			for(int j = 1; j <= i; j++) {
				sum2 += j;
			}
		}
		System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+…+(1+2+3+…+100) = " + sum2);
		
	}
}
