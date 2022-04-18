package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test893 {
    public int numSpecialEquivGroups(String[] words) {
    Set<String> set=new HashSet<>();
    for(String str:words){
        int[]count=new int[52];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a'+26*(i%2)]++;
        }
        set.add(Arrays.toString(count));
    }
    return set.size();
    }
    //
    @Test
    public void test(){
        String[]strs=new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroups(strs));
    }
}
