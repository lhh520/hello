package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test419 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length==0)
            return lists;
         backtrace(nums,0);
//    for(int i=0;i< lists.size();i++){
//        System.out.println(lists.get(i).toString());
//    }
        return lists;
    }
    public void backtrace(int[] nums,int index){
        if(list.size()>=2&&list.get(list.size()-1)>list.get(list.size()-2))
        lists.add(new ArrayList<>(list));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i< nums.length;i++){
            if(list.get(list.size()-1)>nums[i])
                continue;
            list.add(nums[i]);
            backtrace(nums,i+1);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        System.out.println(findSubsequences(nums));
    }
}
