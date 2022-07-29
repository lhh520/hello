package testproject;

import org.junit.Test;

public class K个逆序对数组 {
    int count=0;
    private int[] temp;
    public int reversePairs(int[] nums){
        if(nums.length<=0){
            return 0;
        }
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
        return count;
    }
    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) return ;
        int mid = lo - (lo - hi) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
    // 治
    // 等价于两个有序数组合并 [lo..mid] 和 [mid+1..hi]
    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) temp[i] = nums[i];
        int cnt = lo;
        int i = lo, j = mid + 1;
        while (i <= mid || j <= hi) {
            if (i > mid) nums[cnt++] = temp[j++];
            else if (j > hi) nums[cnt++] = temp[i++];
            else if (temp[i] <= temp[j]) nums[cnt++] = temp[i++];
            else {
                count+=(mid-i+1);
                nums[cnt++] = temp[j++];
            }

        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
