package testproject;

import org.junit.Test;

public class Student implements Cloneable{
    public int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student stu=null;
        try {
            stu=(Student) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return stu;
    }
    @Test
    public void test() throws CloneNotSupportedException {
        Student stu1=new Student();
        stu1.setNumber(3);
        Student stu2=(Student) stu1.clone();
        System.out.println(stu1.getNumber());
        System.out.println(stu2.getNumber());
        stu2.setNumber(5);
        System.out.println(stu1.getNumber());
        System.out.println(stu2.getNumber());
    }
}
