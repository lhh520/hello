package testproject;

import org.junit.Test;

public class 连续字符 {
    public int maxPower(String s) {
        int max=0;
        int i=0;
        //char pre=s.charAt(0),cur=s.charAt(0);
        int pre=0,cur=0;
        while (i<s.length()){
            while (i<s.length()&&s.charAt(i)==s.charAt(pre)){
                i++;
                max=Math.max(max,i-pre);
            }
            pre=i;
            i++;
        }
        return max;
    }
    @Test
    public void test(){
       String s = "ccbccbb";
       System.out.println(maxPower(s));
    }
}
