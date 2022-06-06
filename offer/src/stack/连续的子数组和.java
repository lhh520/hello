package stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //前缀和
        int n=nums.length;
        int[]preSum=new int[n+1];
        preSum[0]=0;
        for(int i=1;i<=n;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(preSum));
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int diff=preSum[j]-preSum[i];
                if(diff%k==0&&(j-i)>=2){
                    //System.out.println("i+ "+i+" j "+j);
                    return true;
                }
            }
        }
        return false;
    }
    //
    public boolean checkSubarraySum1(int[] nums, int k){
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int n=nums.length;
        int[]preSum=new int[n+1];
        preSum[0]=0;
        int render=-1;
        for(int i=0;i<n;i++){
            render=(render+nums[i])%k;
            if(map.containsKey(render)){//如果已经包含
                int prev=map.get(render);//获取前面的
                if(i-prev>=2){
                    return true;
                }
            }else {
                map.put(render,i);
            }

        }
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{23,2,4,6,6};
        boolean kk=checkSubarraySum1(nums,7);
        System.out.println(kk);
    }
}
