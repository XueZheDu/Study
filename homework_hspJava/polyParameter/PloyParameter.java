package cam.gnkjxy.dome1.polyParameter;

/*
    定义员工类Employee，包含姓名和月工资[private],以及计算年工资getAnnual 的方法。
    普通员工和经理继承了员工，经理类多了奖金bonus属性和管理manage方法，
    普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法

    测试类中添加一个方法showEmpAnnal(Employee e),实现获取任何员工对象的年
    工资，并在main方法中调用该方法[e.getAnnual()]

    测试类中添加一个方法, testWork,如果是普通员工，则调用work方法，如果是经
    理，则调用manage方法

 */

public class PloyParameter {
    public static void main(String[] args) {
        Worker worker = new Worker("小王", 23000);
        Manager manager = new Manager("小李", 50000, 100000);
        PloyParameter ployParameter = new PloyParameter();

        ployParameter.showEmpAnnal(worker);
        ployParameter.showEmpAnnal(manager);

        ployParameter.testWork(worker);
        ployParameter.testWork(manager);

    }

    public void showEmpAnnal(Employee e) {
        System.out.println(e.getName() + "的年薪为" + e.getAnnual());
    }

    public void testWork(Employee e) {
        if(e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("不做处理");
        }
    }
}
