package dp;

public class 通配符匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][]dp=new boolean[m][n];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else {
                break;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }else if(p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
    //
    public int findSe(int[]nums1,int[]nums2){
        int res=0;
        int[][]dp=new int[nums1.length+1][nums2.length+1];

        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
    //最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int[][]dp=new int[m][n];
        for(int i=1;i<=m;i++){
            char char1=text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char char2=text2.charAt(i-1);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
