package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和2 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    int sum=0;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used=new boolean[candidates.length];
        backtrace(candidates,0,target);

        return lists;
    }
    public void backtrace(int[] candidates,int index,int target){
        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false){
                continue;
            }
            sum=sum+candidates[i];
            list.add(candidates[i]);
            used[i]=true;
            backtrace(candidates,i+1,target);
            sum=sum-candidates[i];
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    @Test
    public void test(){
        int[] candidates=new int[]{10,1,2,7,6,1,5};
        List<List<Integer>>uu=combinationSum2(candidates,8);
        for(List<Integer>ii:lists){
            System.out.println(ii.toString());
        }
    }
}
