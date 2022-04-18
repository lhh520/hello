package offertest1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer079 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return lists;
        dfs(nums,0);
        System.out.println(lists.toString());
        return lists;
    }
    public void dfs(int[]nums,int index){
        if(index>nums.length-1) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums,index+1);
        list.remove(list.size()-1);
        dfs(nums,index+1);
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,2,3};
        subsets(nums);
    }
}
