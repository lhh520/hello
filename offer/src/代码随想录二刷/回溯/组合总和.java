package 代码随想录二刷.回溯;
import org.junit.Test;

import java.util.*;
public class 组合总和 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates,0,target);
        return lists;
    }
    public void backtrace(int[] candidates, int index,int target){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target<0||index==candidates.length){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            target-=candidates[i];
            list.add(candidates[i]);
            backtrace(candidates,i,target);
            target+=candidates[i];
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[]candidates=new int[]{2,3,6,7};
        //System.out.println();
        List<List<Integer>>ans=combinationSum(candidates,7);
        for(List<Integer>ll:ans){
            System.out.println(ll.toString());
        }
    }
}
