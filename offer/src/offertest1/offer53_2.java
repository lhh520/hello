package offertest1;

import java.util.HashMap;

public class offer53_2 {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]-i!=0)
                return i;
        }
        return -1;
    }
}
