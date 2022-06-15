package testproject;

import org.junit.Test;

public class 回文素数 {
    public int primePalindrome(int n) {
        while (true){
            if(cheack(n)&&cheack1(n)){
                return n;
            }
            n++;
        }
    }
    //判断是不是素数
    boolean cheack(int a){
        int n=(int)Math.sqrt(a);
        int i;
        for(i=2;i<=n;i++){
            if(a%i==0){
                break;
            }
        }
        if(i>n){
            return true;
        }
        return false;
    }
    //判断回文
    boolean cheack1(int a){
        String ss=Integer.toString(a);
        if(ss.length()==1){
            return true;
        }
        int i=0,j=ss.length()-1;
        while (i<j){
            if(ss.charAt(i)!=ss.charAt(j)){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(primePalindrome(6));
    }
}
