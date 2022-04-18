import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer>map=new HashMap<>();
        List<String>ans=new ArrayList<>();
        for(int i=0;i<s.length()-10;i++)
        {   String temp=s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.get(temp)==2)
                ans.add(temp);
        }
        return ans;
    }
}
