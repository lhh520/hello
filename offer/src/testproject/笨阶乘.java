package testproject;

import org.junit.Test;

public class 笨阶乘 {
    public int clumsy(int n) {
        int last=n%4;
        int sum=0;
        boolean flag=false;
        while (n>=4){
            if(!flag){
                flag=true;
                sum+=n*(n-1)/(n-2);
            }else {
                sum-=n*(n-1)/(n-2);
            }
            sum=sum+(n-3);
            n=n-4;
        }
        if(last==3){
            return sum-6;
        }
        if(last==2){
            return sum-2;
        }
        if(last==1){
            return sum-1;
        }
        if(last==0){
            return sum;
        }
        return 0;
    }
    @Test
    public void test(){
        System.out.println(clumsy(4));
    }
}
