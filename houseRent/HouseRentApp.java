package cam.gnkjxy.dome1.houseRent;

import cam.gnkjxy.dome1.houseRent.view.HouseView;

/**
 * 房屋出租系统-设计
 * (1)项目设计-程序框架图(分层模式=>当软件比较复杂，需要模式管理)
 * 房屋租赁程序框架图(分层模式)
 * 1.系统有那些类[文件] 2.明确类与类的调用关系
 * HouseView.java <=> 类 [界面层]
 * 1.显示界面 2.接收用户输入 3.调用HouseService完成对房屋信息的各种操作
 * HouseService.java <=> 类 [业务层]
 * 1.响应HouseView的调用 2.完成对房屋信息的各种操作(增删改查 crud [create][read][update][delete])
 * House.java <=> 类 [domain/model(模型)/数据层]
 * 1.一个House对象表示一个房屋信息 2.House类中有哪些属性，可以通过给出的界面分析得到
 * HouseRentApp.java
 * main{//程序入口
 * //创建HouseView对象，调用该对象，显示主菜单
 * }
 * 工具类 [也算业务层]
 * 完成获取用户各种输入
 */
public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("=====================你已退出房屋出租系统=====================");
    }
}

/*
实现步骤
(1)准备工具类Utility，提高开发效率
(2)创建House类
(3)项目功能实现-显示主菜单和完成退出软件功能
说明：实现功能的三部曲[明确功能->思路分析->代码实现]
功能说明：用户打开软件，可以看到主菜单，可以退出软件
思路分析：在HouseView.java中，编写一个方法mainMenu，显示菜单
代码实现：
(4)项目功能实现-完成显示房屋列表功能
思路分析：
1.在HouseView.java中编写listHouse方法，显示房屋列表[界面]
2.在HouseService.java中编写一个list()方法，返回所有的房屋信息，响应listHouse方法的调用
(5)项目功能实现-完成添加房屋信息的功能
思路分析：
1.编写addHouse()，接收用户输入[界面]，调用add(House newHouse)方法
2.编写add(House newHouse)，将新的House对象加入到houses数组，返回boolean
(6)项目功能实现-完成删除房屋信息的功能
思路分析：
1.编写delHouse()，接收用户输入[界面]，调用del(int delId)
2.编写del(int delId)，完成删除指定House对象，返回boolean
(7)项目功能实现-完善退出确认功能
思路分析：
1.编写exit()，接收用户输入[界面]
(8)项目功能实现-完成根据id查找房屋信息的功能
思路分析：
1.编写findHouse()，接收用户输入[界面]
2.编写findById(int findId)，查找指定House对象，查找成功返回House对象，失败返回null
(9)项目功能实现-完成修改房屋信息的功能
思路分析：
1.编写updateHouse()，接收用户输入[界面]，调用findById(int findId)

 */