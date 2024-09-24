package com.gnkjxy.demo2.homework2;

import java.util.Scanner;

public class Homework2 {
	public static void main(String[] args) {
		/*
		4.已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如: 
		[10,12,45,90],添加23后，数组为[10,12,23,45,90]
		
		 */
		
		//思路分析
		//(1)将添加的数与数组元素比较，找到大于添加的数的第一个数组元素
		//两种情况：
		//1.找到了：用sub记录该下标
		//2.没找到，下标记录为arr.length
		//(2)数组扩容
		//数组元素拷贝到扩容后的数组中
		//当 i < sub 时：arrNew[i] = arr[i]
		//当 i == sub 时：arrNew[i] = newNum
		//当 i > sub 时：arrNew[i] = arr[i-1]
		//(3)将 arr 指向 arrNew
		
		int[] arr = {10, 12, 45, 90};
		int arrLen = arr.length;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要添加的整数:)");
		int newNum = sc.nextInt();
		int sub = -1;
		
		//(1)将添加的数与数组元素比较，找到大于添加的数的第一个数组元素
		for(int i = 0; i < arrLen; i++) {
			if(newNum < arr[i]) {
				//1.找到了：用sub记录该下标
				sub = i;
				break;
			}
		}
		if(sub == -1) {
			//2.没找到，下标记录为arr.length
			sub = arrLen;
		}
		
		//(2)数组扩容
		int[] arrNew = new int[arrLen + 1];
		//数组元素拷贝到扩容后的数组中
		for(int i = 0; i < arrLen + 1; i++) {
			if(i < sub) {
				arrNew[i] = arr[i];
			} else if(i == sub) {
				arrNew[i] = newNum;
			} else {
				arrNew[i] = arr[i-1];
			}
		}
		
		//遍历，输出扩容前的arr
		System.out.println("扩容前的arr:");
		for(int i = 0; i < arrLen; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//(3)将 arr 指向 arrNew
		arr = arrNew;
		
		//遍历，输出扩容后的arr
		System.out.println("扩容后的arr:");
		for(int i = 0; i < arrLen + 1; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
