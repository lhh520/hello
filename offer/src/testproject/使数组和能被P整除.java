package testproject;

import java.util.HashMap;
//https://leetcode.cn/problems/make-sum-divisible-by-p/solution/shu-zu-zheng-chu-wen-ti-hui-zong-qian-zh-xzjc/
public class 使数组和能被P整除 {
    public int minSubarray(int[] nums, int p) {
        int ans = Integer.MAX_VALUE;
        HashMap<Long , Integer> map = new HashMap<>();
        //用 mod 存储 和 的余数
        long mod = 0;
        for(int num: nums){
            mod += num;
        }
        mod = mod % p;
        if(mod == 0){
            return 0; //如果 余数为零，就说明整个数组的和是能被整除的！
        }
        long sum = 0;       //sum存储的是 nums[0] 到 nums[i]的和，也就是前缀和
        map.put((long)0,-1);//把 0 设置为 -1，因为数组起始坐标为0！
        for(int i = 0;i < nums.length;i ++){
            sum += nums[i];
            long counter = sum % p;//求出 前缀和 对 p 取余!
            long aimnum  =  (counter -  mod + p) % p; //求出目标的前缀和
            if(map.get(aimnum) != null){
                ans = Math.min(ans,i - map.get(aimnum));
            }
            map.put(counter,i);//将当前位置的前缀和存储map中！
        }
        return ans >= nums.length ? -1 : ans;
    }
}
