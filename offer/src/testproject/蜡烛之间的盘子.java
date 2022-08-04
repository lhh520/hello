package testproject;

public class 蜡烛之间的盘子 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[]chars=s.toCharArray();
        int n=s.length();
        int[]PreSum=new int[n];
        for(int i=0,sum=0;i<n;i++){
            if(s.charAt(i)=='*'){
                sum++;
            }
            PreSum[i]=sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[]ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[]query=queries[i];
            int x=right[query[0]],y=left[query[1]];//表示距离左边和右边最近的两个蜡烛
            if(x==-1||y==-1||x>=y){
                ans[i]=0;
            }else {
                ans[i]=PreSum[y]-PreSum[x];
            }
        }
        return ans;
    }
}
