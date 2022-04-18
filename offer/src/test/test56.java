package test;

import org.junit.Test;

// nums = [2,3,1,1,4]
public class test56 {
    public int jump(int[] nums) {
    if(nums==null||nums.length==0||nums.length==1)
        return 0;
    int count=0;
    //当前覆盖的最大区域
    int curDistance=0;
    //最大的覆盖区域
    int maxDistance=0;
    for(int i=0;i<nums.length;i++){
        maxDistance=Math.max(maxDistance,i+nums[i]);//当前可以到达的最远的路径
        //当前一步，再跳一步就达到了末尾
        if(maxDistance>=nums.length-1){
            count++;
            break;
        }
        if(i==curDistance){
            curDistance=maxDistance;
            count++;
        }
    }
    return count;
    }
    public int jump2(int[] nums){

        int end=0;
        int max=0;
        int step=0;
        int s=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,i+nums[i]);//当前所可以到达的最远的位置
            if(i==end){
                end=max;
                step++;
            }
        }
        return step;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,1,1,4};
        System.out.println(jump2(nums));
    }
}
