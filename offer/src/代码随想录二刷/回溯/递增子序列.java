package 代码随想录二刷.回溯;

import java.util.*;

public class 递增子序列 {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    int[]nums;
    public List<List<Integer>> findSubsequences(int[] nums){
        this.nums=nums;
        backtrace(0);
        return ans;
    }
    public void backtrace(int index){

    }
}
