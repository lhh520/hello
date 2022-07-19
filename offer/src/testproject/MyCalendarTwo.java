package testproject;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<int[]> booked;
    List<int[]>overlaps;
    public MyCalendarTwo() {
        booked=new ArrayList<>();
        overlaps=new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[]arr:overlaps){
            int l=arr[0],r=arr[1];
            if (l<end&&start<r){//已经发生了重复
                return false;
            }
        }
        for(int []arr:booked){
            int l=arr[0],r=arr[1];
            if(l<end&&start<r){
                //记录重复两次的值
                overlaps.add(new int[]{Math.max(l,start),Math.min(r,end)});
            }

        }
        booked.add(new int[]{start,end});
        return true;
    }
}
