package test;

import org.junit.Test;

import java.util.Arrays;

public class 适龄的朋友 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left=0;
        int right=0;
        int count=0;
        for(int age:ages){
            if(age<15){
                continue;
            }
            while (ages[left]<=0.5*age+7){
                ++left;
            }
            while (right+1<ages.length&&ages[right+1]<=age){
                ++right;
            }
            count+=right-left;
        }
        return count;
    }
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, ans = 0;
        for (int k = 0, i = 0, j = 0; k < n; k++) {
            while (i < k && !check(ages[i], ages[k])) i++;
            if (j < k) j = k;
            while (j < n && check(ages[j], ages[k])) j++;
            if (j > i) ans += j - i - 1;
        }
        return ans;
    }
    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }



    @Test
    public void test(){
        int[]ages=new int[]{16,17,18};
        System.out.println(numFriendRequests1(ages));
    }
}
