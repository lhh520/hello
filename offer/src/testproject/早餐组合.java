package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 早餐组合 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int sum=0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int j=0;
        for(int i=0;i<staple.length;i++){
            if(staple[i]+drinks[0]>x){
                break;
            }
            int cur=staple[i]+drinks[j];
            if(cur<=x){

            }
//            for(int j=drinks.length-1;j>=0;j--){
//                if(staple[i]+drinks[j]<=x){
//                    sum=sum+j+1;
//                    sum=sum%1000000007;
//                    break;
//                }
//            }
        }
        return sum%1000000007;
    }
    @Test
    public void test(){
        int[]tuple=new int[]{10,20,5};
        int[]ss=new int[]{5,5,2};
        System.out.println(breakfastNumber(tuple,ss,15));
    }
}
