package 新刷题;

import java.util.Arrays;

public class 需要添加硬币的数量 {
    public int minimumAddedCoins(int[] coins, int target) {
        //
        Arrays.sort(coins);
        int ans=0,s=1,i=0;
        while (s<=target){
            if(i<coins.length&&coins[i]<=s){
                s+=coins[i];
                i++;
            }else {
                s=s*2;
                ans++;
            }
        }
        return ans;
    }
}
