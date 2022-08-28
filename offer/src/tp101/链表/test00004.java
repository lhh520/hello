package tp101.链表;

import java.util.Arrays;
import java.util.*;

public class test00004 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]stsr=str.split(" ");
        long n=Long.parseLong(stsr[0]);
        long k=Long.parseLong(stsr[1]);
        String str44=sc.nextLine();
        String[]hh=str44.split(" ");
        long []nums=new long [hh.length];
        for(int i=0;i<hh.length;i++){
            nums[i]=Long.parseLong(hh[i]);
        }

        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long t=nums[i]*nums[j];
                if(t>=k){
                    count++;
                }
            }

        }
        System.out.println(2*count);
    }
}
