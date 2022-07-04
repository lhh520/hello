package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        timePoints.addAll(timePoints);
        int ret=Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++){
            String[] t1=timePoints.get(i).split(":");
            String[] t2=timePoints.get(i-1).split(":");
            int time=Integer.parseInt(t1[0])*60+Integer.parseInt(t1[1])-Integer.parseInt(t2[0])*60-Integer.parseInt(t2[1]);
            ret=Math.min(ret,Math.min(Math.abs(time),24*60-Math.abs(time)));
        }
        return ret;
    }
    @Test
    public void test(){
        List<String> timePoints=new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        int a=findMinDifference(timePoints);
        System.out.println(a);
    }
}
