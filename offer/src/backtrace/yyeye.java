package backtrace;

import org.junit.Test;

import java.util.Arrays;

public class yyeye {
    int count=0;
    public int combinationSum (int[] candidates, int target) {
        // write code here
        Arrays.sort(candidates);
        backtrace(candidates,target,0);
        return count;
    }
    public void backtrace(int[]candidates,int target,int index){
        if(target<0){
            return;
        }
        if(target==0){
            count++;
            return;
        }
        for(int i=index;i<candidates.length;i++){
            target-=candidates[i];
            backtrace(candidates,target,i);
            target+=candidates[i];
        }
    }
    @Test
    public void test(){
        //[2,3,4,5],9
        int[]candidates=new int[]{2,3,4,5};
        System.out.println(combinationSum(candidates,9));
    }
}
