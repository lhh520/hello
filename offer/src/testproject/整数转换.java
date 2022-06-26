package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 整数转换 {
    public int convertInteger(int A, int B) {
        List<Integer>l1=getBits(A);
        List<Integer>l2=getBits(B);
        for(int i=l1.size();i<32;i++){
            l1.add(0);
        }
        for(int i=l2.size();i<32;i++){
            l2.add(0);
        }
        System.out.println(l1.size());
        System.out.println(l2);
        int ret=0;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)!=l2.get(i)){
                ret++;
            }
        }
        return ret;
    }
    public List<Integer> getBits(int A){
        List<Integer>ret=new ArrayList<>();
        if(A>=0)
        while (A!=0){
            ret.add(A%2);
            A=A/2;
        }
        System.out.println(ret);
        return ret;
    }
    //
    public int convertInteger1(int A, int B){
        int C=A^B;
        int ans=0;
        while (C!=0){
            C=C&(C-1);
            ans++;
        }
        return ans;
    }
    @Test
    public void test(){
        int A = 29 , B = 15;
        System.out.println(convertInteger(A,B));
    }
}
