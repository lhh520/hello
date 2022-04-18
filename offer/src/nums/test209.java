package nums;

import org.junit.Test;

public class test209 {
    public int minSubArrayLen(int target, int[] nums) {
      int sumnum=0;
      int len=nums.length;
      int start=0;
      int res=Integer.MAX_VALUE;
      for(int i=0;i<len;i++){
          sumnum=sumnum+nums[i];
          while (sumnum>target) {
              int length = i - start + 1;
              res=res<length?res:length;
              sumnum=sumnum-nums[start];
              start++;
          }
      }
      return res==Integer.MAX_VALUE?0:res;
    }
    @Test
    public void test(){
        int[]nums =new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
}
