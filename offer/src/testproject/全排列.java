package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 全排列 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
         if(nums==null){
             return lists;
         }
         for(int i=0;i<nums.length;i++){
             list.add(nums[i]);
         }
         backtrace(nums,0);
         return lists;
    }
    public void backtrace(int[]nums,int index){
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<nums.length;i++){
            Collections.swap(list,index,i);//交换了index 和之后所有的值
            backtrace(nums,index+1);//
            Collections.swap(list,index,i);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        List<List<Integer>>listes=permute(nums);
        for(List<Integer>l:listes){
            System.out.println(l.toString());
        }
    }
}
