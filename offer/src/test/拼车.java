package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int max=0;
        int len=trips.length;
        for(int i=0;i<len;i++){
            max=Math.max(max,trips[i][2]);
        }
        int[]nums=new int[max+1];//表示所有的时刻
        for(int i=0;i<len;i++){
            int j=0;
            for(j=trips[i][1];j<trips[i][2];j++){
                nums[j]+=trips[i][0];
            }

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>capacity){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        //[[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
        int[][]trips =new int[][]{{9,3,4},{9,1,7},{4,2,4},{7,4,5}};
        int capacity = 23;
        System.out.println(carPooling(trips,capacity));
    }
}
