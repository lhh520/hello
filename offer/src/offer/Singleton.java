package offer;

public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton()
    {

    }
    public static Singleton getUniqueInstance()
    {
        //判断对象是否实例
        if(uniqueInstance==null)
            synchronized (Singleton.class)
            {
                if(uniqueInstance==null)
                    uniqueInstance=new Singleton();
            }
        return uniqueInstance;
    }
}
