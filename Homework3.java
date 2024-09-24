package com.gnkjxy.demo2.homework3;

public class Homework3 {
	public static void main(String[] args) {
		/*
		5.随机生成10个整数(1-100的范围)保存到数组，并倒序打印以及求平均值、求最大
		值和最大值的下标、并查找里面是否有8
		(int)(Math.random() * 100) + 1
		Math.random():用于生成大于等于0.0，小于1.0的类型为double值
		 */
		
		int[] arr = new int[10];
		int arrLen = arr.length;
		for(int i = 0; i < arrLen; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		
		//遍历，输出arr
		for(int i = 0; i < arrLen; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//倒序打印
		for(int i = arrLen - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//求平均值
		double sum = 0;
		for(int i = 0; i < arrLen; i++) {
			sum += arr[i];
		}
		System.out.println("平均值为" + (sum / arrLen));
		
		//求最大值和最大值的下标
		int maxNum = arr[0], sub = 0;
		for(int i = 1; i < arrLen; i++) {
			if(maxNum < arr[i]) {
				maxNum = arr[i];
				sub = i;
			}
		}
		System.out.println("最大值为" + maxNum + "最大值的下标为" + sub);
		
		//查找里面是否有8
		int index = -1;
		for(int i = 0; i < arrLen; i++) {
			if(8 == arr[i]) {
				System.out.println("有8，下标为" + i);
				index = 1;
				break;
			}
		}
		if(index == -1) {
			System.out.println("没有8");
		}
		
	}
}
