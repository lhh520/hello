package 代码随想录二刷.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    boolean[]used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used=new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrace(candidates,0,target,used);
        return lists;
    }
    public void backtrace(int[] candidates, int index,int target,boolean[]used){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false){
                continue;
            }
            System.out.println(1);
            used[i]=true;
            target-=candidates[i];
            list.add(candidates[i]);
            backtrace(candidates,target,i+1,used);
            list.remove(list.size()-1);
            target+=candidates[i];
            used[i]=false;
        }
    }
    @Test
    public void test(){
        //candidates = [10,1,2,7,6,1,5], target = 8
        int[]candidates=new int[]{10,1,2,7,6,1,5};
        List<List<Integer>>ans=combinationSum2(candidates,8);
        for(List<Integer>ll:ans){
            System.out.println(ll.toString());
        }
    }
}
