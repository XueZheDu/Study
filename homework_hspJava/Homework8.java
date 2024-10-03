package com.gnkjxy.demo2.homework8;

public class Homework8 {
	public static void main(String[] args) {
		/*
		14.扩展题
		有个人Tom设计他的成员变量.成员方法可以电脑猜拳
		电脑每次都会随机生成0, 1, 2 
		0 表示石头 1 表示剪刀 2 表示布
		并要可以显示Tom的输赢次数(清单)
		
		 */
		
		//测试
		Tom tom = new Tom();
		for(int i = 0; i < 5; i++) {
			tom.game();
		}
		tom.show();
		
	}
}

class Tom {
	//记录tom输赢的次数
	int win = 0;
	int lost = 0;
	
	public void game() {
		//电脑每次都会随机生成0, 1, 2 
		int computer = (int)(Math.random() * 10) % 3;
		int tomNum = (int)(Math.random() * 10) % 3;
		System.out.println("电脑：" + computer);
		System.out.println("Tom：" + tomNum);
		if(tomNum == 0 && computer == 1) {
			System.out.println("Tom赢了");
			this.win++;
		} else if(tomNum == 1 && computer == 2) {
			System.out.println("Tom赢了");
			this.win++;
		} else if(tomNum == 2 && computer == 0) {
			System.out.println("Tom赢了");
			this.win++;
		} else if(tomNum == computer) {
			System.out.println("平局");
		} else {
			System.out.println("Tom输了");
			this.lost++;
		}
	}
	
	public void show() {
		System.out.println("Tom赢的次数：" + this.win);
		System.out.println("Tom输的次数：" + this.lost);
	}
}
