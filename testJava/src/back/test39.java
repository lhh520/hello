package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test39 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates,target,0);
        return lists;
    }
    public void backtrace(int[] candidates,int target,int index){
        if(target<0) return;
        if(target==0){//终止条件
            //System.out.println(list.toString());
            lists.add(new ArrayList<>(list));
            return;
        }
        //处理本层元素
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            backtrace(candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
    public int sum(List<Integer>list2){
        int sunlist=0;
        for(int i:list2){
            sunlist+=i;
        }
        return sunlist;
    }
    @Test
    public void test(){
        int[]ca=new int[]{2,3,6,7};
        System.out.println(combinationSum(ca,7));
    }
}
