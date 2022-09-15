package LCP;

import java.util.*;

public class test8d8d8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strs=str.split(" ");
        int a=Integer.parseInt(strs[0]);
        int b=Integer.parseInt(strs[1]);
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a,int b){
        while (b!=0){
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
}
