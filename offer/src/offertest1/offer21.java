package offertest1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer21 {
    public int[] exchange(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int[]ans=new int[nums.length];
        if(nums.length==0)
            return ans;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                ans[j]=nums[i];
                list.add(i);
                j++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(i)){
                ans[j]=nums[i];
                j++;
            }

        }
        return ans;
    }

    //原地更换
    public int[] exchange1(int[] nums){
       int[]ans=new int[nums.length];
       int oddCount=0;
       int oddBegin=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]%2!=0)
               oddCount++;
       }
       for(int i=0;i<nums.length;i++){
           if(nums[i]%2!=0){
               ans[oddBegin++]=nums[i];
           }else {
               ans[oddCount++]=nums[i];
           }
       }
       return ans;
    }

    @Test
    public void test(){
        int[]nums=new int[]{2,4,6};
        int[]p=exchange1(nums);
        System.out.println(Arrays.toString(p));
    }
}
