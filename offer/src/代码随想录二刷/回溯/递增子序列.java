package 代码随想录二刷.回溯;

import org.junit.Test;

import java.util.*;

public class 递增子序列 {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    int[]nums;
    public List<List<Integer>> findSubsequences(int[] nums){
        this.nums=nums;
        backtrace(0);//开始回溯
        return ans;
    }
    public void backtrace(int index){
        if(path.size()>=2){//不能返回 否则只剩下了长度为2的数据
            ans.add(new ArrayList<>(path));
        }
        if(index>= nums.length){
            return;
        }
        boolean[]used=new boolean[201];
        for(int i=index;i< nums.length;i++){
            if(path.size()>0&&nums[i]<path.get(path.size()-1)||used[nums[i]+100]){
                continue;
            }
            path.add(nums[i]);
            used[nums[i]+100]=true;
            backtrace(i+1);
            path.remove(path.size()-1);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,6,7,7};
        List<List<Integer>>ans=findSubsequences(nums);
        for(List<Integer>li:ans){
            System.out.println(li.toString());
        }
    }

}
