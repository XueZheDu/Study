package cam.gnkjxy.homework_hspJava.homework13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1.编程题
定义个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
分别创建以下方法:
(1)public void save(String id,T entity):保存T类型的对象到Map成员变量中
(2)public T get(String id):从map中获取id对应的对象
(3)public void update(String id,T entity):替换map中key为id的内容，改为entity对象
(4)public List<T> list():返回map中存放的所有T对象
(5)public void delete(String id):删除指定id对象
定义一个User类:
该类包含: private成员变量(int类型)id, age;(String类型)name
创建DAO类的对象，分别调用其save、get、update、list、delete方法来操作User对象，
使用Junit单元测试类进行测试。
 */
public class Homework13 {
    public static void main(String[] args) {

    }

    @Test
    public void testDAO() {
        DAO<User> userDAO = new DAO<>();

        userDAO.save("1001", new User(1001, 23, "jack"));
        userDAO.save("1002", new User(1002, 24, "hsp"));
        System.out.println(userDAO);
        System.out.println(userDAO.get("1001"));
        userDAO.update("1001", new User(1001, 25, "tom"));
        List<User> list = userDAO.list();
        System.out.println(list);
        userDAO.delete("1001");
        System.out.println(userDAO.list());
    }
}

class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id,T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id,T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
