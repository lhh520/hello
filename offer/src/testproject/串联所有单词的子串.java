package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() == 0)
            return res;
        int len = words[0].length();
        int num = words.length;
        for(int i = 0; i < s.length(); i++)
        {
            List<String> marked = new ArrayList<>();
            for(String str : words)
                marked.add(str);

            int j = i + len * num;//需要匹配的长度
            if(j > s.length())
                continue;

            String frac = s.substring(i, j);//需要匹配的最长的长度
            for(int k = 0; k <= j-i - len; k += len)
            {
                String singleStr = frac.substring(k, k+len);
                if(!marked.contains(singleStr))
                    break;
                else
                    marked.remove(singleStr);
            }
            if(marked.size() == 0)
                res.add(i);
        }
        return res;
    }

}
