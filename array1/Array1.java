package com.gnkjxy.demo2.array1;

import java.util.Scanner;

public class Array1 {
	public static void main(String[] args) {
		/*
		1.要求:实现动态的给数组添加元素效果，实现对数组扩容。
		1)原始数组使用静态分配int[] arr = {1,2,3} 
		2)增加的元素，直接放在数组的最后arr = {1,2,3,4]}
		3)用户可以通过如下方法来决定是否继续添加，添加成功，是否继续？y/n 
		
		 */
		
		//思路分析
		//1.实现数组扩容
		//创建新数组：int arrNew = new int[arr数组长度加1]
		//arr内容复制到arrNew
		//将新元素放到arrNew最后的位置
		//arr指向新数组
		//2.循环，询问是否继续添加
		
		int[] arr = {1,2,3};
		int len;			//原数组长度
		Scanner sc = new Scanner(System.in);
		do {
			len = arr.length;
			int[] arrNew = new int[len + 1];
			//将arr内容复制到arrNew
			for(int i = 0; i < len; i++) {
				arrNew[i] = arr[i];
			}
			//接收新元素 
			System.out.println("请输入要添加的元素:)");
			arrNew[len] = sc.nextInt();
			arr = arrNew;
			System.out.println("添加成功");
			//遍历添加后的数组
			for(int i = 0; i < len + 1; i++) {
				System.out.print(arr[i] + " ");
			}
			//询问
			System.out.println("是否继续添加？y/n");
			if(sc.next().charAt(0) == 'n') {
				break;
			}
		}while(true);
		
		/*
		2.有一个数组{1,2,3,4,5}，可以将该数组进行缩减，
		提示用户是否继续缩减，每次缩减最后那个元素。当只剩下最后一个元素，提示，不能再缩减。
		
		 */
		
		int[] arr2 = {1,2,3,4,5};
		do {
			int len2 = arr2.length;
			int[] arrNew = new int[len2 - 1];
			//将arr2内容复制到arrNew
			for(int i = 0; i < len2 - 1; i++) {
				arrNew[i] = arr2[i];
			}
			//指向新数组
			arr2 = arrNew;
			System.out.println("缩减成功");
			//遍历缩减后的arr2
			for(int i = 0; i < len2 - 1; i++) {
				System.out.print(arr2[i] + " ");
			}
			//判读是否只剩最后一个元素
			if(arr2.length == 1) {
				System.out.println("数组只剩下最后一个元素，不能再缩减");
				break;
			} else {
				System.out.println("是否继续缩减？y/n");
				if(sc.next().charAt(0) == 'n') {
					break;
				}
			}
		}while(true);
		
	}
}
