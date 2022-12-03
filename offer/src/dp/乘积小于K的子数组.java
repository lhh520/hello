package dp;

import org.junit.Test;

import java.util.Arrays;

public class 乘积小于K的子数组 {
    public int FindMax(int[]A) {
        int m=A.length;
        if(m == 0) return -1;
        int begin = 0;
        int end = m - 1;
        int MP =  (begin + end)/2;
        while(MP > 0 && MP < m -1) {
            if(A[MP] > A[MP+1] && A[MP] > A[MP-1]){
                return A[MP];
            }else if (A[MP] < A[MP+1]){
                begin = MP+ 1;
                MP= begin + (end - begin)/2;
            }else{
                end = MP- 1;
                MP= begin + (end - begin)/2;
            }
        }
        if(MP == 0) return A[0];
        if(MP == m-1) return A[m-1];
        return -1;
    }
    //
    public void Zeros(int[] arr)
    {   int m=arr.length;
        for(int i=0;i<m;i++) {
            if(arr[i]==0) {
                for(int j=m-1;j>i;j--) {
                    arr[j]=arr[j-1];
                }
                i++;
            }
        }
    }

    public boolean finadall(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        if(nums[nums.length - 1] > sum){
            return false;
        }
        int[] arr = new int[k];
        Arrays.fill(arr, sum);
        return help(nums, nums.length - 1, arr, k);
    }
    boolean help(int[] nums, int cur, int[] arr, int k){
        if(cur < 0){
            return true;
        }
        for(int i = 0; i < k; i++){
            if(arr[i] == nums[cur] || (cur > 0 && arr[i] - nums[cur] >= nums[0])){
                arr[i] -= nums[cur];
                if(help(nums, cur - 1, arr, k)){
                    return true;
                }
                arr[i] += nums[cur];
            }
        }
        return false;
    }

    //int main(int argc, char* argv[])
    public int getAns(int k1,int k2,int d1,int d2,int t,int x)

    {
        int[][]dp=new int[t][3];
        for(int i=0;i<t;i++) {
            dp[i][0]=Math.max(i-1>=0?dp[i-1][0]:0,(i-k1>=0?dp[i-k1][0]:0)+d1);
            dp[i][1]=Math.max(i-1>=0?dp[i-1][1]:0,(i-k2>=0?dp[i-k2][1]:0)+d2);
            dp[i][2]=Math.max(i-1>=0?dp[i-1][2]:0, (i-k1>=0?dp[i-k1][0]:0)+(i-k2>=0?dp[i-k2][1]:0)+(d1+d2)*(1+x));
            if(dp[i][0]+dp[i][1]<dp[i][2]) {
                dp[i][0]=i-k1>=0?dp[i-k1][0]+d1*(1+x):d1*(1+x);
                dp[i][1]=i-k2>=0?dp[i-k2][1]+d2*(1+x):d2*(1+x);
            }
            else {
                dp[i][2]=dp[i][0]+dp[i][1];
            }


        }
        return dp[t-1][2];

    }



    @Test
    public void test(){
        int[]nums=new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(finadall(nums,4));
    }
}
