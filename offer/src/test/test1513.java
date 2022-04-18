package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test1513 {
    public int numSub(String s) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                int j=i;
                while(j<s.length()&&s.charAt(j)=='1'){
                    j++;
                }
                map.put(j-i,map.getOrDefault(j-i,0)+1);
                i=j;
            }
        }

        int sum=0;
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            //System.out.println(entry.getKey()+" : "+entry.getValue());
            for(int j=0;j<entry.getValue();j++){
                sum=sum+ (entry.getKey()+1)* entry.getKey()/2;
            }

        }
        return sum;

    }
    @Test
    public void test(){
        String s="0110111";
        System.out.println(numSub(s));
    }
}
