package offertest1;

import org.junit.Test;

import java.util.Arrays;

public class offer60 {
    public double[] dicesProbability(int n) {
    double[] dp=new double[6];
    Arrays.fill(dp,1.0/6.0);
    for(int i=2;i<=n;i++){
        double []temp=new double[5*i+1];//可能性一共有6*n-(n-1)=5n+1
        for(int j=0;j<6;j++){
            temp[i+j]=temp[i+j]+dp[i]/6;//代表上一次的
        }
        dp=temp;
    }
    return dp;
    }
    @Test
    public void test(){
        double[] dp=dicesProbability(2);
        System.out.println(Arrays.toString(dp));
    }
}
