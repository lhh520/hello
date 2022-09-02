package backtrace;

public class User {
    private String name;
    private int age;
    {
        System.out.println("A");
    }
    static{
        System.out.println("B");
    }
    User(){
        System.out.println("C");
    }
    User(String name,int age){
        System.out.println("D");
    }
}
