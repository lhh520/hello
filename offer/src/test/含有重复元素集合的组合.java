package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 含有重复元素集合的组合 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n=candidates.length;
        Arrays.sort(candidates);
        boolean[]flag=new boolean[n];
        backtrace(candidates,0,flag,target);
        return lists;
    }
    public void backtrace(int[]candidates,int index,boolean[]flag,int sum){
        if(sum==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index>=candidates.length){
            return;
        }
        //可以选择的方向和位置，现在是每个只可以用一次
        for(int i=index;i<candidates.length&&sum-candidates[i]>=0;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&flag[i-1]==false){
                continue;
            }
            flag[i]=true;
            list.add(candidates[i]);
            sum=sum-candidates[i];
            backtrace(candidates,i+1,flag,sum);
            flag[i]=false;
            list.remove(list.size()-1);
            sum=sum+candidates[i];
        }
        //
    }
    @Test
    public void test(){
        int[]candidates =new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>>li=combinationSum2(candidates,target);
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i).toString());
        }
    }
}
