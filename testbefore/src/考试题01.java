import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 考试题01 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>=target){
                count++;
            }
        }
        return count;
    }

    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public int countCompleteSubarrays(int[] nums) {
        boolean[]flags=new boolean[nums.length];
        backtrace(0,nums);
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
        return 0;
    }
    public void backtrace(int index,int[]nums){
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index>nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtrace(i+1,nums);
            list.remove(list.size()-1);
        }
    }
    public boolean isHaveAll(){
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,1,2,2};
        countCompleteSubarrays(nums);
    }
}
