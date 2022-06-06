package stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    boolean[]used;
    public List<List<Integer>> permute(int[] nums){
        if(nums.length==0){
            return lists;
        }
        used=new boolean[nums.length];
        perHelper(nums);
        return lists;
    }
    public void perHelper(int[]nums){
        if(list.size()== nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            perHelper(nums);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,2,3};
        List<List<Integer>>li=permute(nums);
        for(List<Integer>ll:li){
            System.out.println(ll.toString());
        }
    }

}
