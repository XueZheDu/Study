#include "game.h"

int main()
{
	test();
	return 0;
}

//����
void test()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("��ѡ��:>");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("��Ϸ���˳���\n");
			break;
		default:
			printf("ѡ�����������ѡ��\n");
			break;
		}
	} while (input);
}

//��Ϸʵ��
void game()
{
	char ret = 0;
	//����ʵ������
	char board[ROW][COL] = {0};
	//��ʼ������
	InitBoard(board, ROW, COL);
	//��ӡ����
	system("cls");
	DisplayBoard(board, ROW, COL);
	//����
	while (1)
	{
		//�������
		PlayerMove(board, ROW, COL);
		//��ӡ����
		system("cls");
		DisplayBoard(board, ROW, COL);
		//�ж�����Ƿ�Ӯ
		ret = IsWin(board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
		//��������
		ComputerMove(board, ROW, COL);
		//��ӡ����
		system("cls");
		DisplayBoard(board, ROW, COL);
		//�жϵ����Ƿ�Ӯ
		ret = IsWin(board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
	}
	if (ret == '*')
	{
		printf("��Ӯ�ˣ�\n");
	}
	else if(ret == '#')
	{
		printf("�����ˡ�\n");
	}
	else
	{
		printf("ƽ�֣�\n");
	}
}
