import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer>set=new HashSet<>();
        for(Map.Entry<Integer,Integer>entry: map.entrySet())
        {
            int fre=entry.getValue();
            if(!set.add(fre))
                return false;
        }
        return  true;
    }
}
