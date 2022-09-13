package plan92.test;
import org.junit.Test;

import java.util.*;
public class 最长连续序列 {
    public int longestConsecutive(int[] nums){
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int cur=num;
                int curlong=1;
                while (set.contains(cur+1)){
                    cur++;
                    curlong++;
                }
                max=Math.max(max,curlong);
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
