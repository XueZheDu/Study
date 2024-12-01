package cam.gnkjxy.dome1.arraysExercise;

import java.util.Arrays;
import java.util.Comparator;

/*
Arrays类课堂练习
案例:自定义Book类，里面包含name和price，按price排序(从大到小)。
要求使用两种方式排序，对对象的某个属性排序，有一个Book[] books = 4本书对象。
使用前面学习过的传递实现Comparator接口匿名内部类，也称为定制排序。
Book[] books = new Book[4];
books[0] = new Book("红楼梦", 100);
books[1] = new Book("金瓶梅", 90);
books[2] = new Book("青年文摘~", 5);
books[3] = new Book("java从入门到入土", 300);

 */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘~", 5);
        books[3] = new Book("java从入门到入土", 300);

        //使用定制排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double priceVal = b2.getPrice() - b1.getPrice(); //从小到大则 b1.getPrice() - b2.getPrice()
                if (priceVal > 0) {
                    return 1;
                } else if (priceVal == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        System.out.println(Arrays.toString(books));

    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
