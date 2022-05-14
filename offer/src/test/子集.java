package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       backtrace(nums,0);
       return lists;
    }
    public void backtrace(int[]nums,int index){
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtrace(nums,i+1);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        List<List<Integer>>ans=subsets(nums);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).toString());
        }
    }
}
