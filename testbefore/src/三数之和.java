import java.util.*;
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>lists=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,r=nums.length-1;
            while (l<r){
                if(nums[l]+nums[i]+nums[r]<0){
                    l++;
                }else if(nums[l]+nums[i]+nums[r]>0){
                    l--;
                }else {
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(set.add(new ArrayList<>(list))){
                        lists.add(new ArrayList<>(list));
                    }
                    l++;
                }
            }
        }
        return lists;
    }
}
