package plan92.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 整数反转 {
    public int reverse(int x) {
        int res=0;
        int flag=1;
        if(x<0){
            x=-x;
            flag=0;
        }
        while (x!=0){
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)
            {
                return 0;
            }
            res=res*10+x%10;
            x=x/10;
        }
        return flag==0?-res:res;
    }
    @Test
    public void test(){
        System.out.println(reverse(123));
    }
}
