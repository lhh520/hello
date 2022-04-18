package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test1189 {
    public int maxNumberOfBalloons(String text) {
        char[]chars=new char[]{'b','a','l','o','n'};
        List<Character>list= new ArrayList<>();
        for(int i=0;i<chars.length;i++)
        {
            list.add(chars[i]);
        }
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<text.length();i++)
        {   char c=text.charAt(i);
            if(list.contains(c)){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<chars.length;i++)
        {
            int num=map.getOrDefault(chars[i],0);
            if(chars[i]=='l'||chars[i]=='o'){
                num=num/2;
            }
            min=Math.min(num,min);
        }
        return min;
    }
}
