package 新刷题;

import java.util.*;

public class 交换得到字典序最小的数组 {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Create a list of pairs (element, index)
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[]{nums[i], i});
        }

        // Sort the list based on the first element of each pair
        vec.sort(Comparator.comparingInt(a -> a[0]));

        // Split the list into segments where adjacent elements' difference does not exceed the limit
        List<List<int[]>> segs = new ArrayList<>();
        int last = -limit;
        for (int i = 0; i < n; i++) {
            if (vec.get(i)[0] - last > limit) {
                segs.add(new ArrayList<>());
            }
            segs.get(segs.size() - 1).add(vec.get(i));
            last = vec.get(i)[0];
        }

        int[] ans = new int[n];

        // Sort each segment and fill back into the sequence
        for (List<int[]> seg : segs) {
            List<Integer> pos = new ArrayList<>();
            for (int[] p : seg) {
                pos.add(p[1]);
            }
            pos.sort(Integer::compareTo);

            for (int i = 0; i < seg.size(); i++) {
                ans[pos.get(i)] = seg.get(i)[0];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {8, 2, 1, 3};
        int limit = 2;
        int[] result = lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(result));
    }
}
