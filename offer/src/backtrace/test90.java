package backtrace;

import org.junit.Test;

import java.util.*;

public class test90 {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    Set<List<Integer>>set=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0)
            return lists;
        Arrays.sort(nums);
        boolean[]flag=new boolean[nums.length];
        backtrace(nums,0,flag);
            for(int i=0;i< lists.size();i++){
        System.out.println(lists.get(i).toString());
    }
        return lists;
    }
    public void backtrace(int[] nums,int index,boolean[]flag){
        if(set.add(new ArrayList<>(list)))
        lists.add(new ArrayList<>(list));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i< nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                if(flag[i]==true){
                    continue;
                }
            }
            flag[i]=true;
            list.add(nums[i]);
            backtrace(nums,i+1,flag);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,2};
        subsetsWithDup(nums);
    }
}
