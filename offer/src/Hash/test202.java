package Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class test202 {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while (n!=1&&!set.contains(n)){

             set.add(n);
            n=getNext(n);
        }
        return n==1;
    }
    public int getNext(int n){
        int res=0;
        while(n>0){
            int temp=n%10;
            res+=temp*temp;
            n=n/10;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(isHappy(19));
    }
}
