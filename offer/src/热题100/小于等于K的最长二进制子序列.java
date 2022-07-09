package 热题100;

import org.junit.Test;

public class 小于等于K的最长二进制子序列 {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), m = 32 - Integer.numberOfLeadingZeros(k);
        if (n < m) return n;
        int ans = Integer.parseInt(s.substring(n - m), 2) <= k ? m : m - 1;
        return ans + (int) s.substring(0, n - m).chars().filter(c -> c == '0').count();
    }
    @Test
    public void test(){
        //s = "1001010", k = 5
        System.out.println(longestSubsequence("1001010",5));
    }
}
