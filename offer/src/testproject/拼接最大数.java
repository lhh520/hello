package testproject;

import java.util.Arrays;

public class 拼接最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = 0, n = 0;
        if(nums1 == null || (m = nums1.length) == 0)    return maxNum(nums2, k);
        if(nums2 == null || (n = nums2.length) == 0)    return maxNum(nums1, k);
        int[] res = null;
        for(int i = Math.max(0, k-n), limit = Math.min(m, k); i <= limit; i++){
            int[] a = maxNum(nums1, i);
            int[] b = maxNum(nums2, k-i);
            int[] c = merge(a, b);
            res = res == null || compare(res, 0, c, 0) < 0 ? c : res;
        }
        return res;
    }
    private int[]maxNum(int[]nums,int k){
        int n=nums.length;
        k=n-k;//需要移除的数字
        if(k==0) return nums.clone();
        if(k==n) return new int[0];
        int[]stack=new int[n];
        int top=0;
        for(int i=0;i<n;i++){
            while (k>0&&top>0&&nums[i]>stack[top-1]){
                top--;
                k--;
            }
            stack[top++]=nums[i];
        }
        top-=k;
        return  Arrays.copyOfRange(stack,0,top);
    }
    // 合并两个数组 成 最大值
    // nums1 != null && nums2 != null
    private int[] merge(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            res[k++] = compare(nums1, i, nums2, j) >= 0 ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            res[k++] = nums1[i++];
        }
        while(j < n){
            res[k++] = nums2[j++];
        }

        return res;
    }
    // 比较 nums1[i,m)  和 nums2[j, n)
    // nums1 != null && nums2 != null
    private int compare(int[] nums1, int i, int[] nums2, int j){
        int m = nums1.length;
        int n = nums2.length;

        for(int k=0, limit = Math.min(m-i, n-j); k < limit; k++){
            if(nums1[i + k] != nums2[j + k])
                return Integer.compare(nums1[i + k], nums2[j + k]);
        }

        return Integer.compare(m - i, n - j);
    }

}
