package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return lists;
        }
        backtrace(candidates,target,0);
        return lists;
    }
    public void backtrace(int[] candidates, int target,int index){
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index==candidates.length||target<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){//每一层可选的数字
            list.add(candidates[i]);
            target=target-candidates[i];
            backtrace(candidates,target,i);
            list.remove(list.size()-1);
            target=target+candidates[i];
        }
    }
    @Test
    public void test(){
        int[]candidates =new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>>temp=combinationSum(candidates,target);
        for(List<Integer>li:temp){
            System.out.println(li.toString());
        }
    }
}
