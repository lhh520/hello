import java.util.*;

public class testMap
{
    public static void main(String[] args) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        map1.put(1,2);
        map1.put(6,4);
        map1.put(5,6);
        //而是按照哈希值来存的所以取数据也是按照哈希值取得
        for(Map.Entry entry: map1.entrySet())
        {
            int key= (int) entry.getKey();
            System.out.println(key);
        }
        //输出156
        LinkedHashMap<Integer,Integer> map2=new LinkedHashMap<>();
        map2.put(1,2);
        map2.put(6,4);
        map2.put(5,6);
        for(Map.Entry entry1: map2.entrySet())
        {
            int key= (int) entry1.getKey();
            System.out.println(key);
        }
        //输出165
        TreeSet<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(6);
        set.add(5);
        Iterator itSet = set.iterator();
        while(itSet.hasNext())
            System.out.print(itSet.next() + "\t");
    }
}
