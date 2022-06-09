package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int pre=-1;
        while (n!=0){
            int temp=n%2;
            if(pre==-1){
                pre=temp;
                n=n/2;
                continue;
            }
            if(pre==temp){
                return false;
            }
            pre=temp;
            n=n/2;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(hasAlternatingBits(7));
    }
}
