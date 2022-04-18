package offertest1;

import org.junit.Test;

import java.util.Arrays;

public class offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0)
            count++;
        }
        int[]temp=new int[count];
        int j=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0)
            {
                temp[j]=nums[i];
                j++;
            }
        }
        int sum=0;
        for(int i=1;i<temp.length;i++){
            if(temp[i]==temp[i-1])
                return false;
            sum=sum+ temp[i]-temp[i-1]-1;
        }
        if(sum>nums.length-count)
            return false;
        else
            return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,0,1,2,5};
        System.out.println(isStraight(nums));
    }
}
