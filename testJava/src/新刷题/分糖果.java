package 新刷题;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 分糖果 {
    public int distributeCandies(int[] candyType) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<candyType.length;i++){
            set.add(candyType[i]);
        }
        return Math.min(candyType.length/2,set.size());
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,2,3};
        System.out.println(distributeCandies(nums));
    }
}
