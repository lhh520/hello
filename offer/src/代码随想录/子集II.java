package 代码随想录;

import org.junit.Test;

import java.util.*;

public class 子集II {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        boolean[] flag=new boolean[nums.length];
        backtrace(nums,0,flag);
        return lists;
    }
    public void backtrace(int[]nums,int index,boolean[] flag){
        if(set.add(new ArrayList<>(list)))
            lists.add(new ArrayList<>(list));
        if(index>nums.length){
            return;
        }
        for(int i=index;i< nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                if(flag[i])
                continue;
            }
            list.add(nums[i]);
            flag[i]=true;
            backtrace(nums,i+1,flag);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,2};
        List<List<Integer>>lis=subsetsWithDup(nums);
        for(List<Integer>li:lis){
            System.out.println(li.toString());
        }
    }
}
