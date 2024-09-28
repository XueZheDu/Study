package com.gnkjxy.demo2.hanoiTower;

public class HanoiTower {
	public static void main(String[] args) {
		/*
		汉诺塔
		初始柱：A，中间柱：B，目标柱:C，
		思路分析
		1.只有一个盘子的情况，将盘子从 A->B
		2.多个盘子
		(1)将最下面盘子上的其他盘子移到B
		(2)将最下面的盘子A->C
		(3)将B的其他盘子移到C
		
		 */
		
		Tower t1 = new Tower();
		t1.move(5, 'A', 'B', 'C');
		
	}
}

class Tower {
	//输入盘子个数，初始柱名称，中间柱名称，目标柱名称
	//输出移动步骤
	public void move(int num, char a, char b, char c) {
		if(num == 1) {
			System.out.println(a + "->" + c);
		} else {
			//(1)用move方法将最下面盘子上的其他盘子移到B
			//盘子个数为 num-1 ，初始柱为 A ，中间柱为 C ，目标柱 B 
			move(num - 1, a, c, b);
			//(2)将最下面的盘子A->C
			System.out.println(a + "->" + c);
			//(3)将B的其他盘子移到C
			//盘子个数为 num-1 ，初始柱为 B ，中间柱为 A ，目标柱 C
			move(num - 1, b, a, c);
		}
	}
}
