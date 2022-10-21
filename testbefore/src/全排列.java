import org.junit.Test;

import java.util.*;
public class 全排列 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    boolean[]flag;
    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums,0);
        return lists;
    }
    public void backtrace(int[]nums,int index){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                list.add(nums[i]);
                flag[i]=true;
                backtrace(nums,i+1);
                list.remove(list.size()-1);
                flag[i]=false;
            }
        }
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
