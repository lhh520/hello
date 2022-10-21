package hot100;

public class tesddd {
    public int maximumSum (int[] arr) {
        int n=arr.length;
        int[][]f=new int[n][2];
        f[0][0]=arr[0];
        f[0][1]=0;
        for(int i=1;i<n;i++){
            f[i][1]=Math.max(f[i-1][1]+arr[i],f[i-1][0]);
            f[i][0]=Math.max(f[i-1][0]+arr[i],arr[i]);
        }
        int res=f[0][0];
        for(int i=1;i<n;i++){
            int max=Math.max(f[i][0],f[i][1]);
            res=Math.max(max,res);
        }
        return res;
    }
    public int maximumSum1 (int[] arr){
        int a=arr[0],b=0,ans=arr[0];
        for(int i=1;i<arr.length;i++){
            b=Math.max(b+arr[i],b);
            a=Math.max(a+arr[i],a);
            ans = Math.max(a,b);
        }
        return ans;
    }
}
