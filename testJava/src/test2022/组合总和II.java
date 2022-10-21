package test2022;
import org.junit.Test;

import java.util.*;
public class 组合总和II {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    int sum=0;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        used=new boolean[candidates.length];
        backtrace(candidates,0,target);
        return lists;
    }
    public void backtrace(int[]candidates,int index,int target){
        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            //表示之前已经用过了
            if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false){
                continue;
            }
            sum+=candidates[i];
            list.add(candidates[i]);
            used[i]=true;
            backtrace(candidates,i+1,target);
            used[i]=false;
            sum-=candidates[i];
            list.remove(list.size()-1);
        }

    }

    @Test
    public void test(){
        int[]nums=new int[]{10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>>lists=combinationSum2(nums,target);
        System.out.println(lists);
    }
}
