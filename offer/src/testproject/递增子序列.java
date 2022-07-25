package testproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 递增子序列 {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    int[]nums;
    public List<List<Integer>> findSubsequences(int[] nums){
        this.nums=nums;
        dfs(0);
        return ans;
    }
    public void dfs(int index){
        if(path.size()>=2){
            ans.add(new ArrayList<>(path));
        }
        if(index>=nums.length) return;
        boolean[]used=new boolean[201];
        for(int i=index;i<nums.length;i++){
            if(path.size()>0&&nums[i]<path.get(path.size()-1)||used[nums[i]+100]) continue;
            path.add(nums[i]);
            used[nums[i]+100]=true;
            dfs(i+1);
            path.remove(path.size()-1);
        }
    }
}
