package dp;

import java.util.*;

public class ddddd {
    static int step=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        swap(a,'A','B','C');


    }

    public static void swap(int n,char A,char B,char C){
        if(n==1){
            move(n,A,C);
        }else {
            swap(n-1,A,C,B);
            move(n,A,C);
            swap(n-1,B,A,C);
        }
    }
    public static void move(int id,char x,char y){
        //Move 1 from 1 to 2
        System.out.println("Move "+id+" from "+x+" to "+y);
        step++;
    }
}
