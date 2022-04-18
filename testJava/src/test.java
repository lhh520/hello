import java.util.*;
public class test {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> myres = subsets(nums);
        System.out.println(myres);
    }
    public static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtracks(nums, 0, new LinkedList<>());
        return res;
    }

    //递归遍历数组，每到一个元素就有两种情况：1.选该元素 2.不选该元素
    public static void backtracks(int[] nums, int current, LinkedList<Integer> track) {
        //已经遍历完所有元素
        if (current == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        //不选当前元素
        backtracks(nums, current + 1, track);
        //选当前元素
        track.add(nums[current]);
        backtracks(nums, current + 1, track);
        //撤销选取当前元素（回溯）
        track.removeLast();
    }
}

