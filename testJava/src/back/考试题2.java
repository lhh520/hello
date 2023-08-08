package back;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 考试题2 {
    @Test
    public void test(){
        int[]nums=new int[]{5,5,5,5};
        System.out.println(countCompleteSubarrays(nums));
    }
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int count=0;
        Set<Integer>set1=new HashSet<>();
        for(int i=0;i<=nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(j-i+1<set.size()){
                    continue;
                }
                set1.clear();
                for(int ii=i;ii<=j;ii++){
                    System.out.print(" "+nums[ii]+" ");
                    set1.add(nums[ii]);

                }
                System.out.println();
                if(set1.size()==set.size()){
                    //System.out.println(set.toString());
                    count++;
                }
            }
        }
        return count;
    }
}
