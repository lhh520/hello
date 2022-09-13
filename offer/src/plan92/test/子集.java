package plan92.test;
import org.junit.Test;

import java.util.*;
public class 子集 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        backtrace(nums,0);
        return lists;
    }
    public void backtrace(int[]nums,int index){
        lists.add(new ArrayList<>(list));
        if(index>nums.length){
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
        List<List<Integer>>l=subsets(nums);
        System.out.println(l);
    }
}
