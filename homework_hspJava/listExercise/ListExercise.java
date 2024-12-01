package cam.gnkjxy.dome1.listExercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
List接口课堂练习
添加10个以上的元素(比如String "hello")，在2号位插入一个元素"韩顺平教
育"，获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集
合，要求：使用List的实现类ArrayList完成。
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("List=" + list);

        list.add(1, "韩顺平教育");
        System.out.println("List=" + list);

        System.out.println("第5个元素" + list.get(4));

        list.remove(5);
        System.out.println("List=" + list);
        list.set(6, "world");
        System.out.println("List=" + list);

        Iterator iterator = list.iterator();
        System.out.println("===迭代器遍历===");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
