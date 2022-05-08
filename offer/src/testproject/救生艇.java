package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 救生艇 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int count=0;
        //独自大于
        while (i<=j){
            if(people[i]+people[j]<=limit){
                ++i;
            }
            --j;
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2};
        System.out.println(numRescueBoats(nums,3));
    }
}
