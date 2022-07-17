package testproject;

import java.util.Stack;

public class 叶值的最小代价生成树 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer>st=new Stack<>();
        st.push(Integer.MAX_VALUE);
        int mct=0;
        for(int i=0;i<arr.length;i++){
            while (arr[i]>=st.peek()){
                mct+=st.pop()*Math.min(st.peek(),arr[i]);
            }
            st.push(arr[i]);
        }
        //解决剩下在栈中的数字
        while (st.size()>2){
            mct+=st.pop()*st.peek();
        }
        return mct;
    }
    public int mctFromLeafValues1(int[] arr){
        int n=arr.length;
        int[][]max=new int[n][n];
        for(int j=0;j<n;j++){
            int maxValue=arr[j];
            for(int i=j;i>=0;i--){
                maxValue=Math.max(maxValue,arr[i]);
                max[i][j]=maxValue;
            }
        }
        //
        int[][]dp=new int[n][n];
        for(int j=0;j<n;j++){
            for(int i=j;i>=0;i--){
                int min=Integer.MAX_VALUE;
                for(int k=i;k+j<=j;k++){
                    min=Math.min(min,dp[i][k]+dp[k+1][j]+max[i][k]*max[k+1][j]);
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][n-1];
    }
}
