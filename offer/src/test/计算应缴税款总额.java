package test;

import org.junit.Test;

public class 计算应缴税款总额 {
    public double calculateTax(int[][] brackets, int income) {
        double sum=0;
        if(income==0){
            return sum;
        }
        if(income<=brackets[0][0]){
            sum+=income*brackets[0][1]*1.0/100;
            return sum;
        }
        int i=0;
        for(i=0;i<brackets.length;i++){
            if(brackets[i][0]>=income){
                break;
            }
        }
        System.out.println(i);
        //足额交付的
        int j=0;
        while (j<i&&j< brackets.length-1){
            if(j==0){
                sum+=brackets[0][0]*brackets[0][1]*1.0/100;
                System.out.println(sum);
            }else {
                sum+=(brackets[j][0]-brackets[j-1][0])*brackets[j][1]*1.0/100;
                System.out.println(sum);
            }
            j++;
        }

        //
        if(i>1)
        sum+=(income-brackets[i-1][0])*brackets[i][1]*1.0/100;
        return sum;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{1,0},{2,97},{3,20},{4,89},{5,54}};
        System.out.println(calculateTax(nums,5));
    }
}
