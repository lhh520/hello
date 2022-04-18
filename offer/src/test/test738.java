package test;

import org.junit.Test;

import java.util.Arrays;

public class test738 {
    public int monotoneIncreasingDigits(int n) {
    String[]nums=(n+"").split("");
    //System.out.println(Arrays.toString(nums));
    int start=0;
    for(int i=nums.length-1;i>0;i--){
        if(Integer.parseInt(nums[i])<Integer.parseInt(nums[i-1])){
            nums[i-1]=(Integer.parseInt(nums[i-1])-1)+"";
            start=i;
            break;
        }
    }
    for(int i=start;i<nums.length;i++){
        nums[i]= String.valueOf('9');
    }
    return Integer.parseInt(String.join("",nums));

    }
    @Test
    public void test(){
        int n=112;
        System.out.println(monotoneIncreasingDigits(n));
    }
}
