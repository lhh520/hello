package testproject;

public class 填充书架 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n=books.length;
        int[]dp=new int[n+1];
        dp[1]=books[0][1];
        for(int i=2;i<=n;i++){
            dp[i]=books[i-1][1]+dp[i-1];//下一个的高度 等于之前的高度加上下一本的书  作为基础值参与运算
            int w=books[i-1][0],h=books[i-1][1];
            for(int j=i-1;j>0;j--){
                w+=books[j-1][0];
                if (w>shelfWidth) break;
                h=Math.max(h,books[j-1][1]);
                dp[i]=Math.min(dp[i],dp[j-1]+h);
            }
        }
        return dp[n];
    }
}
