package backtrace;

public class Student extends User{
    {
        System.out.println("a");
    }
    static{
        System.out.println("b");
    }
    Student(){
        System.out.println("c");
    }
    Student(String name,int age){
        super(name,age);
        System.out.println("d");
    }

    public static void main(String[] args) {
        User u=new Student("l",6);
    }
}
