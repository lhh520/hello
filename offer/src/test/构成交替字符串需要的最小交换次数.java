package test;

import org.junit.Test;

public class 构成交替字符串需要的最小交换次数 {
    public int minSwaps(String s) {
        int n0=count(s,'0');
        int n1=count(s,'1');
        int n=s.length();
        //10101 01010
        int res=Integer.MAX_VALUE;
        if(n1==(n+1)/2&&n0==n/2){
            int diff1=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)-'0'==i%2){
                    diff1++;
                }
            }
            res=Math.min(res,diff1/2);
        }
        //
        if(n0==(n+1)/2&&n1==n/2){
            int diff2=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)-'0'!=i%2){
                    diff2++;
                }
            }
            res=Math.min(res,diff2/2);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int count(String s,char c){
        int n=0;
        for(char cc:s.toCharArray()){
            if(cc==c){
                n++;
            }
        }
        return n;
    }
    @Test
    public void test(){

        String s = "111000";
        System.out.println(minSwaps(s));
    }
}
