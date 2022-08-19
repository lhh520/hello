package hot100;
import org.junit.Test;

import java.util.*;
public class 全排列 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    boolean[]flag;
    public List<List<Integer>> permute(int[] nums) {
        flag=new boolean[nums.length];
        backtrace(nums);
        return lists;
    }
    public void backtrace(int[]nums){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                list.add(nums[i]);
                flag[i]=true;
                backtrace(nums);
                list.remove(list.size()-1);
                flag[i]=false;
            }
        }
    }
    @Test
    public void test(){
        int[]candidates =new int[]{2,3,6,7};
        List<List<Integer>>temp=permute(candidates);
        System.out.println(temp);
    }
}
