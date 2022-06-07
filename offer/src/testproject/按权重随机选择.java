package testproject;

import java.util.Random;

public class 按权重随机选择 {
    int[]nums;
    int[]preSum;
    int n;
    int sum=0;
    Random random;
    public 按权重随机选择(int[] w) {
        nums=w;
        n=w.length;
        preSum=new int[n];
        preSum[0]=w[0];
        sum+=w[0];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+w[i];
            sum+=w[i];
        }
    }

    public int pickIndex() {
        int x = (int) (Math.random() * sum) + 1;
        for(int i=0;i<preSum.length;i++){
            if(preSum[i]>x){
                return nums[i];
            }
        }
        return -1;
        //return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0, high = preSum.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (preSum[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
