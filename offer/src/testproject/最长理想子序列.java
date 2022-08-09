package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最长理想子序列 {
    public int longestIdealString(String s, int k) {
        int[]dp=new int[s.length()];
        Arrays.fill(dp,1);
        for(int i=0;i<dp.length;i++){
            char c= s.charAt(i);
            for(int j=0;j<i;j++){
                if(Math.abs(c-s.charAt(j))<=k){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int longestIdealString1(String s, int k) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = Math.max(c - k, 0); j <= Math.min(c + k, 25); j++)
                f[c] = Math.max(f[c], f[j]);
            f[c]++;
        }
        return Arrays.stream(f).max().getAsInt();
    }

    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
    public int lengthOfLIS1(String s, int k) {
        int[] tails = new int[s.length()];
        int res = 0;
        char[]chars=s.toCharArray();
        for(char num : chars) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    @Test
    public void test(){
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s,k));

    }
}
