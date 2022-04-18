package test;

import org.junit.Test;

import java.util.*;

public class test79 {
    public String largestNumber(int[] nums) {
        int[] aa=new int[]{0,0};
        if(Arrays.equals(aa, nums))
        return "0";
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
           list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String t1= Integer.toString(o1);
                String t2= Integer.toString(o2);
                return (t2+t1).compareTo(t1+t2);
            }
        });
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    @Test
    public void test()
    {
        int[]nums = new int[]{0,0};
        System.out.println(largestNumber(nums));
        System.out.println("30".compareTo("3"));
    }
}
