package testproject;

public class Singleton {
    /*懒汉单例模式：将默认的构造参数私有化，不允许从外部进行实例化，只能调用getInstance进行实例化*/
    //但是本类内部仍然可以多次实例化
//    private Singleton(){}
//    private static Singleton singleton=null;
//    public static Singleton getInstance()
//    {
//        if(singleton==null)
//            singleton=new Singleton();
//        return singleton;
//    }
    private Singleton(){//构造方法私有化

    }
    private static Singleton singleton=new Singleton();//无论如何 必然可以实例化一个对象
    public static Singleton getInstance(){
        return singleton;
    }


    public void sout()
    {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        System.out.println(singleton.hashCode());
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton2.hashCode());
        System.out.println("kk");
    }
}
