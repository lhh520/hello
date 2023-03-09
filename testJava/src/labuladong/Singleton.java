package labuladong;

public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getUniqueInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
