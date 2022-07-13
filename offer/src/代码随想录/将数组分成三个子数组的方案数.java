package 代码随想录;

public class 将数组分成三个子数组的方案数 {
    public int waysToSplit(int[] nums) {
        final int MOD = 1000000007;
        int n=nums.length;
        int ans=0;
        int[]sum=new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        for(int i=1,l=2,r=2;i<=n-1;i++){
            l=Math.max(l,i+1);
            r=Math.max(r,i+1);
            while (r<=n-1&&sum[n]-sum[r]>=sum[r]-sum[i]){
                r++;
            }
            while (l<=n-1&&sum[l]-sum[i]<sum[i]){
                l++;
            }
            if(l<r){
                ans+=(r-l);
            }
        }
        return (int)(ans%MOD);
    }
}
