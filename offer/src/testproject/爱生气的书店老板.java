package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //滑动窗口
        //前缀和
        int len=grumpy.length;
        int[]preSum=new int[len];
        int sum=0;
        if(grumpy[0]==0){
            preSum[0]=customers[0];//表示0时刻不生气，则说
        }else {
            preSum[0]=0;
        }
        for(int i=1;i<len;i++){
            preSum[i]=preSum[i-1]+(1-grumpy[i])*customers[i];
        }
        System.out.println(Arrays.toString(preSum));
        //开始滑动
        int left=0,right=minutes;
        for(int i=left;i<right;i++){
            sum+=customers[i];//表示这个之间的所有的顾客都是满意的
        }
        System.out.println(sum);//前三个都是满意的
        int cur=sum+preSum[len-1]-preSum[left];//
        System.out.println(cur);
        int ans=cur;
        while (right<len){
            ans=Math.max(cur,ans);
            sum=sum-customers[left]+customers[right];
            if(left==0){
                cur=sum+preSum[left]+preSum[len-1]-preSum[right];
            }else {
                cur=sum+preSum[left]+preSum[len-1]-preSum[right];
            }
            //System.out.println(cur);
            right++;
            left++;
            ans=Math.max(cur,ans);
        }
        return ans;
    }
    //
    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes){
        int len=grumpy.length;
        int total=0;
        for(int i=0;i<len;i++){
            if(grumpy[i]==0){//已经不生气的人
                total+=customers[i];
            }
        }
        //尽量增加秘密技巧的人数
        int increase=0;
        for(int i=0;i<minutes;i++){
            increase+=customers[i]*grumpy[i];
        }
        int maxIncrease=0;
        for(int i=minutes;i<len;i++){
            //increase=increase-customers[i-minutes]*grumpy[i-minutes]+customers[i]*grumpy[i];
            //向右移动一个形成的差值
            increase=increase-customers[i-minutes]*grumpy[i-minutes]+customers[i]*grumpy[i];
            maxIncrease=Math.max(increase,maxIncrease);
        }
        return maxIncrease+total;
    }
    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes){
        int len=grumpy.length;
        int total=0;
        for(int i=0;i<len;i++){
            if(grumpy[i]==0){//已经不生气的人
                total+=customers[i];
                customers[i]=0;
            }
        }
        int sum=0;
        int max=0;
        for(int i=0;i<len;i++){
            sum+=customers[i];
            if(i>=minutes){
                sum-=customers[i-minutes];
            }
            max=Math.max(max,sum);
        }
        return max+total;
    }
    @Test
    public void test(){
        int[]customers =new int[]{1,0,1,2,1,1,7,5};
        int[]grumpy =new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied2(customers,grumpy,minutes));
    }
}
