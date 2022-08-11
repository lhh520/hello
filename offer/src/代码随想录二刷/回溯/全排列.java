package 代码随想录二刷.回溯;
import org.junit.Test;

import java.util.*;
public class 全排列 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    boolean[]used;
    public List<List<Integer>> permute(int[] nums){
        used=new boolean[nums.length];
        backtrace(nums);
        return lists;
    }
    public void backtrace(int[]nums){
        if(list.size()== nums.length){//唯一的退出条件就是已经接受够了数字
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){//从起始位置开始搜索 表示每层尝试的数字
            if(used[i]){//表示本分支已经用过了 不能再用了
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            backtrace(nums);
            used[i]=false;
            list.remove(list.size()-1);//表示去除最后一个数字
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        List<List<Integer>>res=permute(nums);
        for(List<Integer>kk:res){
            System.out.println(kk.toString());
        }
    }
}
