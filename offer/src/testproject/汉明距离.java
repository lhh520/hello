package testproject;

import org.junit.Test;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int temp=x^y;
        int ans=0;
        while (temp!=0){
            int nn=temp%2;
            if(nn==1){
                ans++;
            }
            temp=temp/2;
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(hammingDistance(1,4));
    }
}
