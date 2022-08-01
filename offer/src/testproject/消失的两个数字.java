package testproject;

public class 消失的两个数字 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int i : nums) sum += i;
        int ts = (1 + n) * n / 2 - sum; //两个缺失元素之和
        int m = ts / 2; //两个元素之间的“分界”（一个缺失元素大于这个值，另一个小于这个值）

        // 将问题转换为求一个缺失元素
        sum = 0;
        for (int i : nums) {
            if (i <= m) sum += i;
        }
        int res = (1 + m) * m / 2 - sum;
        return new int[] {res, ts - res};
    }
}
