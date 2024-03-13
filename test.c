#include "game.h"

int main()
{
	test();
	return 0;
}

//测试
void test()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("请选择:>");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("游戏已退出！\n");
			break;
		default:
			printf("选择错误，请重新选择。\n");
			break;
		}
	} while (input);
}

//游戏实现
void game()
{
	char ret = 0;
	//数组实现棋盘
	char board[ROW][COL] = {0};
	//初始化棋盘
	InitBoard(board, ROW, COL);
	//打印棋盘
	system("cls");
	DisplayBoard(board, ROW, COL);
	//下棋
	while (1)
	{
		//玩家走棋
		PlayerMove(board, ROW, COL);
		//打印棋盘
		system("cls");
		DisplayBoard(board, ROW, COL);
		//判断玩家是否赢
		ret = IsWin(board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
		//电脑走棋
		ComputerMove(board, ROW, COL);
		//打印棋盘
		system("cls");
		DisplayBoard(board, ROW, COL);
		//判断电脑是否赢
		ret = IsWin(board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
	}
	if (ret == '*')
	{
		printf("你赢了！\n");
	}
	else if(ret == '#')
	{
		printf("你输了。\n");
	}
	else
	{
		printf("平局！\n");
	}
}
