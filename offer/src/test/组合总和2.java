package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和2 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates,0);
        return null;
    }
    public void backtrace(int[] candidates,int index){

    }
}
