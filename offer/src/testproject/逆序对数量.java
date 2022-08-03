package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 逆序对数量 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        System.out.println(Arrays.toString(nums));
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
        return ans;
    }
    class BIT{
        private int[]tree;
        private int n;
        public BIT(int n){
            this.n=n;
            this.tree=new int[n+1];
        }
        public  int lowbit(int x){
            return x&(-x);
        }
        public int query(int x){
            int ret=0;
            while (x!=0){
                ret+=tree[x];
                x-=lowbit(x);
            }
            return ret;
        }
        public void update(int x){
            while (x<=n){
                ++tree[x];
                x+=lowbit(x);
            }
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
