package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 准时到达的列车最小时速 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int right= (int) 1e+7;;
        int n=dist.length;
        if (n - 1 >= hour) return -1;
        int left=1;
        while (left<right){//当左小于右的时候
            int mid=(left+right)/2;
            double sum=0.0;
            int t=0;
            for(int i=0;i<dist.length-1;i++){//之前的都要取整数
                 t+=(dist[i]-1)/mid+1;
            }
            sum=sum+t+dist[dist.length-1]*1.0/mid;
            if(sum>hour){//说明太慢了 速度在右边
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
    @Test
    public void test(){
        int[]dist =new int[]{1,3,2};
        double hour = 2.7;
        System.out.println(minSpeedOnTime(dist,hour));
    }
}
