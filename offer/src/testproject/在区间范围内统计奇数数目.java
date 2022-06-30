package testproject;

import org.junit.Test;

public class 在区间范围内统计奇数数目 {
    public int countOdds(int low, int high) {
        int count=0;
        if(low%2==0){
            low++;
            count++;
        }
        if(low>=high){
            return 1;
        }
        if(high%2==0){
            high--;
            count++;
        }
        if(low>=high){
            return 1;
        }
        return count+(high-low)/2+1;
    }
    @Test
    public void test(){
    System.out.println(countOdds(8,10));
    }
}
