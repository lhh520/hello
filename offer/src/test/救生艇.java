package test;

import org.junit.Test;

import java.util.Arrays;

public class 救生艇 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int res=0;
        while (i<=j){
            if (people[i]+people[j]<=limit){
                res++;
                i++;
                j--;
            }else {
                res++;
                j--;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2};
        System.out.println(numRescueBoats(nums,3));
    }
}
