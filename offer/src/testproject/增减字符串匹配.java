package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 增减字符串匹配 {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int[]tre=new int[n+1];
        int lo=0,hi=n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                tre[i]=lo++;
            }else {
                tre[i]=hi--;
            }
        }
        tre[n]=lo;
        return tre;
    }
    @Test
    public void test(){
        String s="IDID";
        int[]uu=diStringMatch(s);
        System.out.println(Arrays.toString(uu));
    }
}
