package cam.gnkjxy.dome1.extendsExercise;

/*
    编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回
    Computer的详细信息
    编写PC子类，继承Computer类，添加特有属性【品牌brand】
    编写NotePad子类，继承Computer类，添加特有属性【演示color】
    编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性
    赋值，以及从Computer类继承的属性赋值，并使用方法井打印输出信息。
 */

public class ExtendsExercise1 {
    public static void main(String[] args) {
        PC pc = new PC("intel", 16, 500, " IBM");
        NotePad notePad = new NotePad("intel", 16, 512, "银色");

        pc.printInfo();
        notePad.printInfo();

    }
}

class Computer {
    private String cpu;
    private int memory;
    private int hardDisk;

    public Computer(String cpu, int memory, int hardDisk) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }

    //get和set方法
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public int getHardDisk() {
        return hardDisk;
    }
    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    //返回基本信息
    public String getDetails(){
        return "cpu：" + cpu + " 内存：" + memory + " 硬盘：" + hardDisk;
    }
}

class PC extends Computer {
    private String brand;

    public PC(String cpu, int memory, int hardDisk, String brand) {
        super(cpu, memory, hardDisk);
        this.brand = brand;
    }

    //get和set方法
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //打印基本信息
    public void printInfo() {
        System.out.println("PC的信息：" + "\n" +  getDetails() + " 品牌：" + brand);
    }
}

class NotePad extends Computer {
    private String color;

    public NotePad(String cpu, int memory, int hardDisk, String color) {
        super(cpu, memory, hardDisk);
        this.color = color;
    }

    //get和set方法
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //打印基本信息
    public void printInfo() {
        System.out.println("NotePad的信息：" + "\n" +  getDetails() + " 颜色：" + color);
    }
}
