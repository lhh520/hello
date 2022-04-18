package offertest1;

import org.junit.Test;

import java.util.Scanner;

public class offer46 {
    public int translateNum(int num) {
        //最后一位一定可以是一种，所以如果前面两位可以进行分割的话，是相加，不然就是和之前一样的
    char[]ch=String.valueOf(num).toCharArray();
    int len=ch.length;
    int[]dp=new int[num];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<=len;i++){
        int n=(ch[i-2]-'0')*10+ch[i-1]-'0';
        if(n>=10&&n<=25){
            dp[i]=dp[i-1]+dp[i-2];
        }else {
            dp[i]=dp[i-1];
        }
    }
    return dp[len];
    }
    @Test
    public void test(){
        Scanner scanner=new Scanner(System.in);

    }
}
