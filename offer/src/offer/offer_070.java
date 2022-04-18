package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class offer_070 {
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        //System.out.println(1);
        for(int i=0;i<nums.length;i++)
          map.put(nums[i],map.getOrDefault(nums[i],1)+1);
        for(Map.Entry<Integer,Integer>entry: map.entrySet())
        {
            if(entry.getValue()==2)
                return entry.getKey();
        }
        return -1;
    }
    public int singleNonDuplicate1(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        //System.out.println(1);
        for(int i=0;i<nums.length;i++)
        {
            if(stack.isEmpty()||nums[i]!=stack.peek())
            {stack.add(nums[i]);
             continue;
            }
            if(nums[i]==stack.peek())
                stack.pop();
        }
        return stack.peek();
    }
    @Test
    public void test()
    {
        int[]nums =new int[] {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate1(nums));
    }
}
