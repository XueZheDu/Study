package cam.gnkjxy.dome1.genericExercise;

import java.util.*;

/*
泛型练习:
1.创建3个学生对象
2.将学生对象放入到HashSet中
3.放入到HashMap中，要求Key是String name, Value就是学生对象
4.使用两种方式遍历
 */
public class GenericExercise {
    public static void main(String[] args) {
        Student student1 = new Student("小明", 20);
        Student student2 = new Student("小红", 21);

        HashSet<Student> studentHashSet = new HashSet<Student>();
        studentHashSet.add(student1);
        studentHashSet.add(student2);
        System.out.println(studentHashSet);

        System.out.println("======HashSet遍历======");
        for (Student student : studentHashSet) {
            System.out.println(student);
        }
        Iterator<Student> studentIterator = studentHashSet.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            System.out.println(student);
        }

        System.out.println("--------------------");

        HashMap<String, Student> studentHashMap = new HashMap<String, Student>();
        studentHashMap.put(student1.getName(), student1);
        studentHashMap.put(student2.getName(), student2);
        System.out.println(studentHashMap);

        System.out.println("======HashMap遍历======");
        Set<String> keySet = studentHashMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "-" +studentHashMap.get(key));
        }

        Collection<Student> values = studentHashMap.values();
        Iterator<Student> iterator = values.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }

        Set<Map.Entry<String, Student>> entrySet = studentHashMap.entrySet();
        for (Map.Entry<String, Student> entry : entrySet) {
            System.out.println(entry.getKey() + "-" +entry.getValue());
        }

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
