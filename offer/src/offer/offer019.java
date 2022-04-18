package offer;

import org.junit.Test;

public class offer019 {
    public boolean validPalindrome(String s) {
    char[] chars=s.toCharArray();
    int[]nums=new int[26];
    for(int i=0;i<chars.length;i++)
    {
        nums[chars[i]-'a']++;
    }
    int count=0;
    for(int i=0;i<nums.length;i++)
    {
        if(nums[i]%2!=0)
            count++;
    }
    if(count<2)
        return true;
    else
        return false;
    }
    public boolean validPalindrome1(String s)
    {
       for(int left=0,right=s.length()-1;left<right;left++,right--)
       {
           //如果不相等，可以选择删除右边或者左边的元素
           if(s.charAt(left)!=s.charAt(right))
               return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
       }
       return true;
    }

    public boolean isPalindrome(String s,int left,int right)
    {
        while (left<right)
        {
            if(s.charAt(left)==s.charAt(right))
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }

    @Test
    public void test()
    {
        String s = "abca";
        System.out.println(validPalindrome1(s));
    }
}
