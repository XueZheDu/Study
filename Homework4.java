package com.gnkjxy.demo2.homework4;

public class Homework4 {
	public static void main(String[] args) {
		/*
		7.写出冒泡排序的代码
		
		 */
		
		int[] arr = {12,34,-1,98,76,55,30};
		int temp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			//将第 i 大的数排在倒数第 i 个位置
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		//遍历，输出arr
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
