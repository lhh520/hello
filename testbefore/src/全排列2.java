import java.util.*;
public class 全排列2 {
    List<List<Integer>>ret=new ArrayList<>();
    List<Integer>temp=new ArrayList<>();
    boolean[]flag;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return ret;
        }
        flag=new boolean[nums.length];
        backtrace(nums);
        return ret;
    }
    public void backtrace(int[] nums){
        if(temp.size()==nums.length){
            ret.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i]){//表示已经被使用过了
                continue;
            }
            flag[i]=true;
            temp.add(nums[i]);
            backtrace(nums);
            flag[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
