package 代码随想录;

import org.junit.Test;

public class 转换字符串的最少操作次数 {
    public int minimumMoves(String s) {
        //连续X
        int sum=0,ret=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='X'){
               sum++;
               i+=2;
            }
        }

        return sum;
    }
    @Test
    public void test(){
        String ss="XXOX";
        System.out.println(minimumMoves(ss));
    }
}
