package cam.gnkjxy.dome1.houseRent.service;

import cam.gnkjxy.dome1.houseRent.domain.House;

/**
 * HouseService.java <=> 类 [业务层]
 * 定义House[]，保存House对象
 * 1.响应HouseView的调用
 * 2.完成对房屋信息的各种操作(增删改查 crud [create][read][update][delete])
 * 方法
 * 1.编写一个list()方法，返回所有的房屋信息
 * 2.编写add(House newHouse)，将新的House对象加入到houses数组，返回boolean
 * 3.编写del(int delId)，完成删除指定House对象，返回boolean
 * 4.编写findById(int findId)，查找指定House对象，查找成功返回House对象，失败返回null
 */
public class HouseService {

    private House[] houses; //保存House对象
    private int houseNums = 1; //记录当前有多少个房屋信息
    private int idCount = 1; //记录id增长到哪个值了

    public HouseService(int size) {
        houses = new House[size];
        //用于测试
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    //find方法，查找指定House对象，查找成功返回House对象，失败返回null
    public House findById(int findId) {
        //遍历
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;
    }

    //del方法，删除一个房屋信息，返回boolean
    public boolean del(int delId) {
        //先找到要删除房屋信息对应的下标(因为删除后并不重新分配id，所以不能将id-1视为下标)
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()) {
                index = i; //记录要删除房屋信息的下标
            }
        }

        if(index == -1) {//说明delId在数组中不存在
            return false;
        }
        //删除房屋信息
        //思路分析：下标从index开始，将后一个房屋信息前移，直到指向最后一个房屋信息前的一个下标，
        //在最后一个房屋信息前移后，将最后房屋信息原来的下标位置内容至null
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null; //houseNums减1后，值等于数组最后的房屋信息前移前的下标
        return true;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse) {
        //判断是否还可以继续添加(暂时不考虑数组扩容问题)
        if (houseNums == houses.length) {//已满，不能添加了
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        //将newHouse对象加入到数组数据末尾，然后houseNums++
        houses[houseNums++] = newHouse;
        //设计一个id自增长机制，更新newHouse的id，idCount先加1，再赋给newHouse
        newHouse.setId(++idCount);
        return true;
    }

    //list方法，返回house
    public House[] list() {
        return houses;
    }
}
