package testproject;

import org.junit.Test;

import java.util.*;

public class 最大整除子集 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[]dp=new int[n];
        int[]pre=new int[n];
        for(int i=0;i<n;i++){
            int len=1;
            int prev=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>len){
                        len=dp[j]+1;
                        prev=j;//表示转化来的数字
                    }
                }
            }
            dp[i]=len;
            pre[i]=prev;
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(pre));
        //找到最大值和起始位置
        int max=-1;
        int begin=-1;
        for(int i=0;i<n;i++){
            if(max<dp[i]){
                max=dp[i];
                begin=i;
            }
        }
        List<Integer>list=new ArrayList<>();
        while (list.size()!=max){
            list.add(nums[begin]);
            begin=pre[begin];
        }
        return list;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        List<Integer>ll=largestDivisibleSubset(nums);
        System.out.println(ll.toString());
    }
}
