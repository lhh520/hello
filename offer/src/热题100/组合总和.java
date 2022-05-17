package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,0);
        return lists;
    }
    public void dfs(int[] candidates, int target,int sum,int index){
        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                break;
            }
            list.add(candidates[i]);
            dfs(candidates,target,sum+candidates[i],i);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[]candicate=new int[]{2,3,6,7};
        List<List<Integer>>nn=combinationSum(candicate,7);
        System.out.println(nn.toString());
    }
}
