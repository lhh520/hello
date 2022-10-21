package hot100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class hshshs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String strs=sc.nextLine();
        String[]hhh=strs.split(" ");
        int[]nums=new int[n];
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(hhh[i]);
            set.add(nums[i]);
        }
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i]-1)){
               //以当前值为最小值
                int[]newss=new int[n];
                int min=nums[i];
                for(int j=0;j<n;j++){
                    newss[j]=min;
                    min++;
                }
                //System.out.println(Arrays.toString(newss));
                int ret=n-longestCommonSubsequence(newss,nums);
                //System.out.println(ret);
                ans=Math.min(ans,ret);
            }
        }
        System.out.println(ans);

    }
    public static int minDistance(int[]word1,int[]word2) {
        int m = word1.length;
        int n = word2.length;
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequence(int[] text1, int[] text2) {
        int n1 = text1.length;
        int n2 = text2.length;

        // 多从二维dp数组过程分析
        // 关键在于  如果记录  dp[i - 1][j - 1]
        // 因为 dp[i - 1][j - 1]  <!=>  dp[j - 1]  <=>  dp[i][j - 1]
        int [] dp = new int[n2 + 1];

        for(int i = 1; i <= n1; i++){

            // 这里pre相当于 dp[i - 1][j - 1]
            int pre = dp[0];
            for(int j = 1; j <= n2; j++){

                //用于给pre赋值
                int cur = dp[j];
                if(text1[i - 1] == text2[j - 1]){
                    //这里pre相当于dp[i - 1][j - 1]   千万不能用dp[j - 1] !!
                    dp[j] = pre + 1;
                } else{

                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }


                pre = cur;
            }
        }

        return dp[n2];
    }

//    public static int minDistance(int[] word1, int[] word2) {
//        int m = word1.length;
//        int n = word2.length;
//        int[][] dp = new int[m+1][n+1];
//        for(int i = 1; i <= m; i++){
//            dp[i][0] = i;
//        }
//        for(int i = 1; i <= n; i++){
//            dp[0][i] = i;
//        }
//        for(int i = 1; i <= m; i++){
//            for(int j = 1; j <= n; j++){
//                int left = dp[i][j-1]+1;
//                int mid = dp[i-1][j-1];
//                int right = dp[i-1][j]+1;
//                if(word1[i-1] != word2[j-1]){
//                    mid ++;
//                }
//                dp[i][j] = Math.min(left,Math.min(mid,right));
//            }
//        }
//        return dp[m][n];
//    }
}
