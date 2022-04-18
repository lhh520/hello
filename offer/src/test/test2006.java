package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test2006 {
    public int countKDifference(int[] nums, int k) {
        int count=0;
        for (int i = 0; i <nums.length+1; i++) {
            for(int j=i;j<nums.length;j++)
            {
                if(Math.abs(nums[j]-nums[i])==k)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-k+1;i++)
        {
            min=Math.min(min,nums[k+i-1]-nums[i]);
        }
        return min;
    }
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(int i=0;i<patterns.length;i++)
        {
            if(word.contains(patterns[i]))
                count++;
        }
        return count;
    }
    public String makeFancyString(String s) {
    StringBuilder sb=new StringBuilder();

        int count=0;
        sb.append(s.charAt(0));
        for (int i = 1; i <s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
                if(count>=2)
                    continue;
                else
                    sb.append(s.charAt(i));
            }
            else
            {   count=0;
                sb.append(s.charAt(i));}
        }
        return sb.toString();
    }
    public int countGoodSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length()-3;i++)
        {

                String temp=s.substring(i,i+3);
                //System.out.println(temp);
                if(check(temp))
                count++;

        }
        return count;
    }
    boolean check(String temp)
    {
        if(temp.charAt(0)==temp.charAt(1)||temp.charAt(0)==temp.charAt(2)||temp.charAt(1)==temp.charAt(2))
        return false;
        return true;
    }
    @Test
    public void test()
    {
        String a="xyzzaz";
        System.out.println(countGoodSubstrings(a));
    }
}
