package test;

import org.junit.Test;

import java.util.Arrays;

public class 解码异或后的数组 {
    public int[] decode(int[] encoded, int first) {
        int n=encoded.length;
        int[]ans=new int[n+1];
        ans[0]=first;
        for(int i=0;i<encoded.length;i++){
            ans[i+1]=ans[i]^encoded[i];
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    @Test
    public void test(){
        int[]encoded=new int[]{1,2,3};
        decode(encoded,1);
    }
}
