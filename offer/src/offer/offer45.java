package offer;

import org.junit.Test;

import java.util.Arrays;

public class offer45 {
    public String minNumber(int[] nums)
    {
      String[] strs=new String[nums.length];
      for(int i=0;i<nums.length;i++)
      {
          strs[i]=String.valueOf(nums[i]);
      }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
      StringBuilder sb=new StringBuilder();
      for(String s:strs)
      {
          sb.append(s);
      }
      return sb.toString();

    }
    @Test
    public void test()
    {
        int[] nums=new int[]{10,2};
        System.out.println(minNumber(nums));
    }
}
