package testproject;

import org.junit.Test;

public class 数组潜逃 {
    public int arrayNesting(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int cur=i,cnt=0;
            while (nums[cur]!=-1){//不包含重复元素 意思就是说重复元素都会被记录下来
                cnt++;
                int c=cur;
                cur=nums[cur];
                nums[c]=-1;
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
}
