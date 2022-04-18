import org.junit.Test;

import java.util.*;

public class test442 {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer>list=new ArrayList<>();
        Set<Integer>stack=new HashSet<>();
        //System.out.println("he");
        for(int i=0;i<nums.length;i++)
        {
            if(!stack.add(nums[i]))
                list.add(nums[i]);
        }
        return list;
    }
    public List<Integer> findDuplicates1(int[] nums) {
        Arrays.sort(nums);
        List<Integer>list=new ArrayList<>();
        //Set<Integer>stack=new HashSet<>();
        //System.out.println("he");
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                list.add(nums[i]);
        }
        return list;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{4,3,2,7,8,2,3,1};
        List<Integer>list=findDuplicates1(nums);
        System.out.println(list.toString());
    }
}
