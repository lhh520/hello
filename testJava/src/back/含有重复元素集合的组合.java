package back;
import org.junit.Test;

import java.util.*;
public class 含有重复元素集合的组合 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        int n=candidates.length;
        Arrays.sort(candidates);
        boolean[]flag=new boolean[candidates.length];

        backtrace(candidates,0,flag,target);
        return lists;
    }
    public void backtrace(int[]candidates,int index,boolean[]flag,int target){
        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&flag[i-1]==false){
                continue;
            }
            list.add(candidates[i]);
            sum+=candidates[i];
            flag[i]=true;
            backtrace(candidates,i+1,flag,target);
            list.remove(list.size()-1);
            sum-=candidates[i];
            flag[i]=false;
        }
    }
    @Test
    public void test(){
        int[]candidates=new int[]{10,1,2,7,6,1,5};
        List<List<Integer>>lists=combinationSum2(candidates,8);
        System.out.println(lists);
    }
}
