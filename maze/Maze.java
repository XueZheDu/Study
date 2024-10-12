package com.gnkjxy.demo2.maze;

public class Maze {
	public static void main(String[] args) {
		/*
		递归调用应用实例-迷宫问题
		1.小球得到的路径，和程序员设置的找路策略有
		关即:找路的上下左右的顺序相关
		2. 再得到小球路径时，可以先使用(下右上左)， 
		再改成(上右下左)，看看路径是不是有变化
		3. 测试回溯现象
		
		 */
		
		//创建地图，用二维数组表示，8行7列，0代表无障碍物，1代表有障碍物
		int[][] map = new int[8][7];
		for(int i = 0; i < map[0].length; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0; i < map.length; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		
		//测试回溯现象
		//map[2][2] = 1;
		
		//打印初始迷宫地图
		System.out.println("=====初始迷宫地图=====");
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		//findWay方法走迷宫
		T t1 = new T();
		t1.findWay(map, 1, 1);
		
		//打印findWay方法走迷宫的路径
		System.out.println("=====findWay方法走迷宫的路径=====");
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		//findWay2方法走迷宫
		//先注释上面findWay2方法走迷宫的代码
//		T t1 = new T();
//		t1.findWay2(map, 1, 1);
//		
//		//打印findWay2方法走迷宫的路径
//		System.out.println("=====findWay2方法走迷宫的路径=====");
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
}

class T {
	/*
	找路方法
	思路分析
	1.找路策略：下->右->上->左
	2.数字信息：0:无障碍物 1:有障碍物 2:这条路能走通 3:这条路走不通
	3.走到一个位置，用2或3标记
	4.当map[6][5] == 2 时，代表已经走到终点
	
	 */
	
	//传入地图和位置，如果下一位置能走通，返回true，否则返回false
	public boolean findWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {//已经走到终点
			return true;
		} else if(map[i][j] == 0) {
			//暂定这个位置能走通
			map[i][j] = 2;
			//按照找路策略，用findWay方法检查这个位置四周有没有通路
			if(findWay(map, i+1, j)) {//找下
				return true;
			} else if(findWay(map, i, j+1)) {//找右
				return true;
			} else if(findWay(map, i-1, j)) {//找上
				return true;
			} else if(findWay(map, i, j-1)) {//找左
				return true;
			} else {//都走不通
				map[i][j] = 3;
				return false;
			}
		} else {
			//map[i][j] == 1,2,3 时，代表这条路有障碍、已走过或走不通，不必在检查是否能走通
			return false;
		}
	}
	
	//改变找路策略 上->右->下->左
	public boolean findWay2(int[][] map, int i, int j) {
		if(map[6][5] == 2) {//已经走到终点
			return true;
		} else if(map[i][j] == 0) {
			//暂定这个位置能走通
			map[i][j] = 2;
			//按照找路策略，用findWay方法检查这个位置四周有没有通路
			if(findWay2(map, i-1, j)) {//找上
				return true;
			} else if(findWay2(map, i, j+1)) {//找右
				return true;
			} else if(findWay2(map, i+1, j)) {//找下
				return true;
			} else if(findWay2(map, i, j-1)) {//找左
				return true;
			} else {//都走不通
				map[i][j] = 3;
				return false;
			}
		} else {
			//map[i][j] == 1,2,3 时，代表这条路有障碍、已走过或走不通，不必在检查是否能走通
			return false;
		}
	}
	
}
