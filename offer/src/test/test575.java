package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class test575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<candyType.length;i++)
        {
            set.add(candyType[i]);
        }
        return set.size()>candyType.length/2?candyType.length/2:set.size();
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,1,2,2,3,3};
        System.out.println(distributeCandies(nums));
    }
}
