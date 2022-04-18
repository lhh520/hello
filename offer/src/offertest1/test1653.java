package offertest1;

import org.junit.Test;

import java.util.Arrays;

public class test1653 {
    public int minimumDeletions(String s) {
        int[]dp=new int[s.length()];
        int[]dp2=new int[s.length()];
        if(s.charAt(s.length()-1)=='b')
            dp2[s.length()-1]=1;
        if(s.charAt(0)=='a')
            dp[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='a'){
                dp[i]=dp[i-1]+1;
            }else
                dp[i]=dp[i-1];
        }
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='b'){
                dp2[i]=dp2[i+1]+1;
            }else
                dp2[i]=dp2[i+1];
        }
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            maxlen=Math.max(maxlen,dp[i]+dp2[i]);
        }

        return s.length()-maxlen;
    }
    @Test
    public void test(){
        String s="a";
        System.out.println(minimumDeletions(s));
    }
}
