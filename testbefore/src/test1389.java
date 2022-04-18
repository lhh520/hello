import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            list.add(index[i],nums[i]);
        }
        int[] traget=new int[nums.length];
        for(int i=0;i<list.size();i++)
        {
            traget[i]=list.get(i);
        }
        return traget;
    }
    @Test
    public void test()
    {
        //nums = [0,1,2,3,4], index = [0,1,2,2,1]
        int[] nums=new int[]{0,1,2,3,4};
        int[]  index=new int[]{0,1,2,2,1};
        int[] target=createTargetArray(nums,index);
        System.out.println(Arrays.toString(target));

    }
}
