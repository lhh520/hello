package LCP;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    //对象设置成为
    private volatile  static Singleton singleton;
    //构造方法私有化
    private Singleton(){

    }
    public static Singleton getUnistance(){
         if(singleton==null){
             synchronized (Singleton.class){
                 if(singleton==null){
                     singleton=new Singleton();
                 }
             }
         }
         return singleton;
    }

    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println(list);
    }
}
