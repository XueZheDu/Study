package cam.gnkjxy.dome1.listExercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
使用List的实现类添加三本图书，并遍历，打印如下效果
名称：xx       价格：xx       作者：xx
名称：xx       价格：xx       作者：xx
名称：xx       价格：xx       作者：xx
要求：
1）按价格排序，从高到低（使用冒泡法）
2）要求使用ArrayList、LinkedList和Vector三种集合实现
 */
public class ListExercise2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        //List list = new LinkedList();
        //List list = new Vector();

        list.add(new Book("红楼梦", 100, "曹雪芹"));
        list.add(new Book("西游记", 10, "吴承恩"));
        list.add(new Book("水浒传", 9, "施耐庵"));
        list.add(new Book("三国演义", 80, "罗贯中"));

        System.out.println("===排序前===");
        for (Object o : list) {
            System.out.println(o);
        }

        sort(list);

        System.out.println("===排序后===");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void sort(List list) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + name + "  \t价格：" + price + "\t\t作者：" + author;
    }
}