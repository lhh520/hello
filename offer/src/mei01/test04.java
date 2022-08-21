package mei01;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nn = sc.nextLine();
        String[] in = nn.split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        String nn1 = sc.nextLine();
        String[] in1 = nn1.split(" ");

        String nn2 = sc.nextLine();
        String[] in2 = nn2.split(" ");


        int[]word1=new int[n];
        for(int i=0;i<n;i++){
            word1[i]=Integer.parseInt(in1[i]);
        }
        //System.out.println(Arrays.toString(word1));
        //
        int[]word2=new int[m];
        for(int i=0;i<m;i++){
            word2[i]=Integer.parseInt(in2[i]);
        }
        //System.out.println(Arrays.toString(word2));
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<=word1.length;i++){
            int tmp=0;
            for(int j=0;j<i;j++){
                tmp+=Math.abs(word1[j]);
            }
            dp[i][0]=tmp;
        }

        for(int j=0;j<=word2.length;j++){
            int tmp=0;
            for(int t=0;t<j;t++){
                tmp+=Math.abs(word2[t]);
            }
            dp[0][j]=tmp;
        }

        for(int i=1;i<=word1.length;i++){
            for(int j=1;j<=word2.length;j++){
                if(word1[i-1]==word2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j-1]+Math.abs(word1[i-1]-word2[j-1]),
                            Math.max(dp[i-1][j]+Math.abs(word1[i-1]),dp[i][j-1]+Math.abs(word2[j-1]))
                            );
                }
            }
        }
        System.out.println(dp[word1.length][word2.length]);


    }
}
