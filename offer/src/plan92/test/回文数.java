package plan92.test;

import org.junit.Test;

public class 回文数 {
    public boolean isPalindrome(int x) {
        String str=String.valueOf(x);
        char[]chars=str.toCharArray();
        int left=0,right=chars.length-1;
        while (left<right){
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isPalindrome(-121));
    }
}
