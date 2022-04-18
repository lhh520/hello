import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class face1710 {
    public boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        //System.out.println("hello");
        while(n!=1)
        {   if(n%4!=0)
            return false;
            n=n/4;
            //if()
        }
        return true;
    }
    @Test
    public void test()
    {
        int n=16;
        System.out.println(isPowerOfThree(n));
    }
}
