package test;

import org.junit.Test;

import java.util.Arrays;

public class 公平分发饼干 {
    int[]bucket;
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        //利用一个桶
        bucket=new int[k];//表示能有K个桶
        Arrays.sort(cookies);
        int sum=0;
        for(int i=0;i<cookies.length;i++){
            sum+=cookies[i];
        }
        int target=sum/k;
        backtrace(cookies,0,target);

        return ans;
    }
    public void backtrace(int[] cookies, int index,int target){
        if(index==cookies.length){
            //应该存储出来
            int max=Integer.MIN_VALUE;
            for(int i=0;i<bucket.length;i++){
                max=Math.max(max,bucket[i]);
            }
            ans=Math.min(ans,max);
            return;
        }
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]>target){//表示已经满了
                continue;
            }
            bucket[i]+=cookies[index];
            backtrace(cookies,index+1,target);
            bucket[i]-=cookies[index];
        }
    }
    @Test
    public void test(){
        int[]cookies =new int[]{8,15,10,20,8};
        int k = 2;
        System.out.println(distributeCookies(cookies,2));
    }
}
