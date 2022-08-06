package testproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 数组中的字符串匹配 {
    public List<String> stringMatching(String[] words) {
        List<String>ret=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String ss=words[i];
            for(int j=0;j< words.length;j++){
                if(i!=j&&ss.contains(words[j])){
                    //ret.add(words[j]);
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
