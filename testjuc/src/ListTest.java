import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//集合类不安全
//java.util.ConcurrentModificationException 并发修改异常！
public class ListTest {


    public static void main(String[] args) {

        List arrayList = new CopyOnWriteArrayList<>();

        for(int i=1;i<=10;i++){
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(arrayList);
            },String.valueOf(i)).start();
        }

    }
}


