package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 全排列 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        //System.out.println(1);
        //lists.add(new ArrayList<>(list));
        backtrace(nums,0);

        return lists;
    }
    public void backtrace(int[]nums,int index){
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            Collections.swap(list,i,index);
            backtrace(nums,index+1);
            Collections.swap(list,i,index);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        List<List<Integer>>lo=permute(nums);
        System.out.println(lo.toString());
    }
}
