package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 连续差相同的数字 {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer>set=new HashSet<>();
        for(int i=1;i<=9;i++){
            set.add(i);
        }
        //开始遍历
        for(int i=1;i<=n-1;i++){
            Set<Integer>set2=new HashSet<>();
            for(int x:set){
                int d=x%10;
                if(d-k>=0){
                    set2.add(x*10+(d-k));
                }
                if(d+k<=9){
                    set2.add(x*10+(d+k));
                }
            }
            set=set2;
        }
        if(set.size()==0){
            return null;
        }
        int[]nums=new int[set.size()];
        int ii=0;
        for(int x:set){
            nums[ii]=x;
            ii++;
        }
        return nums;
    }
    @Test
    public void test(){
        int[]ans=numsSameConsecDiff(3,7);
        System.out.println(Arrays.toString(ans));
    }
}
