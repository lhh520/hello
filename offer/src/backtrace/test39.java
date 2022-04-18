package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test39 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(candidates.length==0)
        return lists;
    backtrace(0,candidates,target);
    for(int i=0;i<lists.size();i++){
        System.out.println(lists.get(i).toString());
    }
    return lists;
    }
    public void backtrace(int index,int[] candidates, int target){
        if(index==candidates.length){
            return;
        }
        if(sum(list)==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[index]);
            backtrace(i+1,candidates,target);
            list.remove(list.size()-1);
            //backtrace(index+1,candidates,target);
        }
    }
    public int sum(List<Integer>list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum=sum+list.get(i);
        }
        return sum;
    }
    @Test
    public void test(){
        int []nums=new int[]{2,3,6,7};
        combinationSum(nums,7);
    }
}
