package offertest1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class offer57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.isEmpty()&&set.contains(target-nums[i]))
                return new int[]{nums[i],target-nums[i]};
        }
        return new int[]{};
    }
}
