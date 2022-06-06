package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        List<String>list=new ArrayList<>();
        list.addAll(timePoints);
        list.addAll(timePoints);
        System.out.println(list.toString());
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            String[]str1=list.get(i-1).split(":");
            int pre=Integer.parseInt(str1[0])*60+Integer.parseInt(str1[1]);
            //
            String[]str2=list.get(i).split(":");
            int cur=Integer.parseInt(str2[0])*60+Integer.parseInt(str2[1]);
            //
            if(cur>=pre){
                min=Math.min(min,cur-pre);
            }else {
                min=Math.min(min,24*60-(pre-cur));
            }
        }
        return min;
    }
    @Test
    public void test(){
        String[]strs=new String[]{"23:59","00:00"};
        List<String>list=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            list.add(strs[i]);
        }
        int aa=findMinDifference(list);
        System.out.println(aa);
    }
}
