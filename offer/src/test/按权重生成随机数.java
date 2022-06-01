package test;

import org.junit.Test;

import java.util.Arrays;

public class 按权重生成随机数 {
    int[]preSum;
    int total;
    public 按权重生成随机数(int[] w) {
        preSum=new int[w.length];
        preSum[0]=w[0];
        for(int i=1;i<w.length;i++){
            preSum[i]=preSum[i-1]+w[i];//
        }
        System.out.println(Arrays.toString(preSum));
        for(int i=0;i<w.length;i++){
            total=total+w[i];
        }
    }

    public int pickIndex() {
        //获得随机数
        int x = (int) (Math.random() * total) + 1;

        return binarySearch(x);
    }
    private int binarySearch(int x) {
        int[]pre=preSum;
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }



    public static void main(String[] args) {
        int[]ans=new int[]{1,2,3};
        按权重生成随机数 nn=new 按权重生成随机数(ans);
    }
}
