package 代码随想录二刷.回溯;
import org.junit.Test;

import java.util.*;
public class 全排列II {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    boolean[]used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);//必须排序 使得相同的数字在一起
        backtrace(nums);
        return lists;
    }
    public void backtrace(int[]nums){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){//used[i-1] 表示已经用过了
                continue;
            }
            if(used[i]){//表示在同一个树枝上用过 不再使用了
                continue;
            }
            if(!used[i]){//同一个树枝还没有使用过
                used[i]=true;
                list.add(nums[i]);
                backtrace(nums);
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,1,2};
        List<List<Integer>>ll=permuteUnique(nums);
        for(List<Integer>l:ll){
            System.out.println(l.toString());
        }
    }
}
