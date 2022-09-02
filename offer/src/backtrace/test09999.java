package backtrace;
import java.util.*;
public class test09999 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<String,Integer>map=new HashMap<>();
        int ret=0;
        while (in.hasNext()) { // 注意 while 处理多个 case
            String bb=in.nextLine();
            String[]bbb=bb.split(",");
            map.put(bbb[0],map.getOrDefault(bbb[0],0)+Integer.parseInt(bbb[1]));

        }
        for(Map.Entry<String,Integer>entry: map.entrySet()){
             int v=entry.getValue();
             if(v>=10){
                 ret++;
             }
        }
        System.out.println(ret);
    }
}
