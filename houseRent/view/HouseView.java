package cam.gnkjxy.dome1.houseRent.view;

import cam.gnkjxy.dome1.houseRent.domain.House;
import cam.gnkjxy.dome1.houseRent.service.HouseService;
import cam.gnkjxy.dome1.houseRent.utils.Utility;

/**
 * HouseView.java <=> 类 [界面层]
 * 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 * 方法：
 * 1.编写mainMenu方法，可以显示主菜单
 * 2.编写listHouse方法，显示房屋列表[界面]
 * 3.编写addHouse()，接收用户输入[界面]
 * 4.编写delHouse()，接收用户输入[界面]
 * 5.编写exit()，接收用户输入[界面]
 * 6.编写findHouse()，接收用户输入[界面]
 * 7.编写updateHouse()，接收用户输入[界面]
 */
public class HouseView {

    private boolean loop = true; //控制显示菜单
    private char key = ' '; //接收用户选择
    private HouseService houseService = new HouseService(3); //设置数组大小为10

    //根据id修改房屋信息
    public void updateHouse() {
        System.out.println("=========================修改房屋信息========================");
        System.out.print("请输入待修改房屋信息的编号(-1退出): ");
        int updateId = Utility.readInt();
        if(updateId == -1) {
            System.out.println("======================放弃修改房屋信息=======================");
            return;
        }
        //调用findById方法，根据输入的updateId，查找对象
        House house = houseService.findById(updateId);
        if(house == null) {
            System.out.println("编号不存在...");
            System.out.println("======================修改房屋信息失败=======================");
            return;
        }
        //修改房屋信息
        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, ""); //如果用户直接回车，则不修改该信息，默认返回""
        if(!"".equals(name)) {//不为""，修改信息
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "): ");
        String phone = Utility.readString(12, "");
        if(!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() +"): ");
        String address = Utility.readString(16, "");
        if(!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("月租(" + house.getRent() + "): ");
        int rent = Utility.readInt(-1); //如果直接回车，返回-1
        if(rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "): ");
        String state = Utility.readString(3, "");
        if(!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("======================修改房屋信息成功=======================");
    }

    //根据id查找房屋信息
    public void findHouse() {
        System.out.println("=========================查找房屋信息========================");
        System.out.print("请输入要查找的房屋编号: ");
        int findId = Utility.readInt();
        //调用findById方法
        House house = houseService.findById(findId);
        if(house != null) {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(house);
            System.out.println("===========================================================");
        } else {
            System.out.println("编号不存在...");
            System.out.println("======================查找房屋信息失败=======================");
        }
    }

    //完成退出确认
    public void exit() {
        //使用Utility提供的readConfirmSelection方法，完成循环确认
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y') {
            loop = false;
        }
    }

    //编写delHouse()，接收用户输入的id，调用Service的del方法
    public void delHouse() {
        System.out.println("=========================删除房屋信息========================");
        System.out.print("请输入待删除房屋信息的编号(-1退出): ");
        int delId = Utility.readInt();
        if(delId == -1) {
            System.out.println("======================放弃删除房屋信息=======================");
            return;
        }
        //该方法循环判断，如果输入的是y/n，退出循环，返回用户选择，否则重复循环
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y') {//真的删除
            if(houseService.del(delId)) {
                System.out.println("======================删除房屋信息成功=======================");
            } else {
                System.out.println("编号不存在...");
                System.out.println("======================删除房屋信息失败=======================");
            }
        } else {
            System.out.println("======================放弃删除房屋信息=======================");
        }
    }

    //编写addHouse()，创建House对象，接收用户输入，调用add方法
    public void addHouse() {
        System.out.println("==========================添加房屋==========================");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);
        //创建一个新的House对象，注意id是系统分配的，用户不能输入id
        House newhouse = new House(0, name, phone, address, rent, state);
        if(houseService.add(newhouse)) {
            System.out.println("=========================添加房屋成功========================");
        } else {
            System.out.println("=========================添加房屋失败========================");
        }
    }

    //编写listHouse()，显示房屋列表
    public void listHouse() {
        System.out.println("==========================房屋列表==========================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list(); //得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null) {//如果为null，则不用再显示后面的数据了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===========================================================");
    }

    //显示主菜单
    public void mainMenu() {

        do {
            System.out.println("\n======================房屋出租系统菜单=======================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择(1-6): ");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while (loop);
    }
}
