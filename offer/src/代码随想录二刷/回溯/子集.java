package 代码随想录二刷.回溯;
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
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtrace(nums,i+1);//表示不会重复de
            list.remove(list.size()-1);
        }
    }
}
