package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 效的正方形 {
    public double dist(int[]p1,int []p2){
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][]nums=new int[4][2];
        nums[0]=p1;
        nums[1]=p2;
        nums[2]=p3;
        nums[3]=p4;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        for(int i=0;i<nums.length;i++){
            System.out.println(Arrays.toString(nums[i]));
        }
        int[][]p=nums;

        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);


    }
    @Test
    public void test(){
        int[]p1 =new int[]{0,0};
        int[]p2 =new int[]{1,1};
        int[]p3 =new int[]{1,0};
        int[]p4 =new int[]{0,1};

        System.out.println(validSquare(p1,p2,p3,p4));
    }
}
