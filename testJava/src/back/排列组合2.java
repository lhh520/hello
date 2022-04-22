package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 排列组合2 {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        backtrace(candidates,target,0);
        return lists;
    }
    public void backtrace(int[] candidates, int target,int index){
       if(sum==target){
           System.out.println(list.toString());
           lists.add(new ArrayList<>(list));
           return;
       }
       for(int i=index;i<candidates.length;i++){
           if(i>index&&candidates[i]==candidates[i-1]||sum+candidates[i]>target)
               continue;
           sum+=candidates[i];
           list.add(candidates[i]);
           backtrace(candidates,target,i+1);
           sum-=list.get(list.size()-1);
           list.remove(list.size()-1);
       }
    }
    @Test
    public void test(){
        int[]candidates =new int[]{10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates,target);
    }
}
