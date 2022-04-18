package testproject;

public class Singleton {
    /*懒汉单例模式：将默认的构造参数私有化，不允许从外部进行实例化，只能调用getInstance进行实例化*/
    //但是本类内部仍然可以多次实例化
    private Singleton(){}
    private static Singleton singleton=null;
    public static Singleton getInstance()
    {
        if(singleton==null)
            singleton=new Singleton();
        return singleton;
    }
    public void sout()
    {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Singleton singleton=new Singleton();
        System.out.println(singleton.hashCode());
        Singleton singleton2=new Singleton();
        System.out.println(singleton2.hashCode());
        System.out.println("kk");
    }
}
