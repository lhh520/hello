package testproject;

import java.util.Arrays;

public class 可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k){
        int n=cardPoints.length;
        int[]window=new int[n-k];
        int sum=0;
        for(int i=0;i<window.length;i++){
            sum+=cardPoints[i];
        }
        int miniSum=sum;
        for(int i=window.length;i<cardPoints.length;i++){
            sum+=cardPoints[i]-cardPoints[i-(n-k)];
            miniSum=Math.max(sum,miniSum);
        }
        return Arrays.stream(cardPoints).sum()-miniSum;
    }
}
