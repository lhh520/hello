package hot100;
import org.junit.Test;

import java.util.*;
public class 组合总和 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates,0,target);
        return lists;
    }
    public void backtrace(int[]candidates,int index,int target){
        if(target==0){
           lists.add(new ArrayList<>(list));
           return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
             list.add(candidates[i]);
             target-=candidates[i];
             backtrace(candidates,i,target);
             list.remove(list.size()-1);
            target+=candidates[i];
        }
    }
    @Test
    public void test(){
        int[]candidates =new int[]{2,3,6,7};
        List<List<Integer>>temp=combinationSum(candidates,7);
        System.out.println(temp);
    }
}
