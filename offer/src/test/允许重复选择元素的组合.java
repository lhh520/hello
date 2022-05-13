package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 允许重复选择元素的组合 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates,0,target);
        //System.out.println(lists.size());
        return lists;
    }
    public void backtrace(int[] candidates,int index,int target){
        if(target==sum){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            sum=sum+candidates[i];
            list.add(candidates[i]);
            backtrace(candidates,i,target);
            list.remove(list.size()-1);
            sum=sum-candidates[i];
        }
    }
    @Test
    public void test(){
       int[]candidates=new int[]{2,3,6,7};
       int target=7;
       List<List<Integer>>ans=combinationSum(candidates,7);
       for(int i=0;i<ans.size();i++){
           System.out.println(ans.get(i).toString());
       }
    }
}
