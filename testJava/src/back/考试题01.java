package back;

import org.junit.Test;

import java.util.*;

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
    Set<Integer> set=new HashSet<>();
    Set<String>set2=new HashSet<>();
    public int countCompleteSubarrays(int[] nums) {
        boolean[]flags=new boolean[nums.length];

        //Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        backtrace(0,nums);
        System.out.println(set.size());
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
        return 0;
    }
    public void backtrace(int index,int[]nums){
        //lists.add(new ArrayList<>(list));
        if(isHaveAll(list)&&set2.add(list.toString())){
            lists.add(new ArrayList<>(list));
        }
        if(index==nums.length){

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
    public boolean isHaveAll(List<Integer>list){
        if(list.size()<set.size()){
            return false;
        }
        Set<Integer>temp=new HashSet<>();
        for(int i=0;i<list.size();i++){
            temp.add(list.get(i));
        }
        if(set.size()==temp.size()){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,1,2,2};
        countCompleteSubarrays(nums);
    }
}
