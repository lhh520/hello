package dp;

import org.junit.Test;

import java.util.Scanner;

public class cdcdsc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt(),a2=sc.nextInt(),b1=sc.nextInt(),b2=sc.nextInt();
        int sum=0;
        while (a2>0&&b2>0){
            sum+=a1;
            sum+=b1;
            a2=a2-b1;
            b2=b2-a1;
        }
        if(a2>0) sum+=a1*10;
        if(b2>0) sum+=b1*10;
        System.out.println(sum);
//        Scanner sc=new Scanner(System.in);
//        int a1=sc.nextInt(),a2=sc.nextInt(),b1=sc.nextInt(),b2=sc.nextInt();
//        int t1=0,t2=0;
//        t1=b1/a2;
//        t2=b2/a1;
//        if(b1%a2!=0){
//            t1++;
//        }
//        if(b2%a1!=0){
//            t2++;
//        }
//        int sum=Math.min(t1,t2)*(a1+a2);
//        if(t1<t2){
//            sum+=a2*10;
//        }
//        if(t2<t1){
//            sum+=a1*10;
//        }
//        System.out.println(sum);
    }

}

//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a1=sc.nextInt(),a2=sc.nextInt(),b1=sc.nextInt(),b2=sc.nextInt();
//        int sum=0;
//        while (a2>0&&b2>0){
//            sum+=a1;
//            sum+=b1;
//            a2=a2-b1;
//            b2=b2-a1;
//        }
//        if(a2>0) sum+=a1*10;
//        if(b2>0) sum+=b1*10;
//        System.out.println(sum);
//    }
