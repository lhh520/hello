package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class youta01 {
    public static void main(String[] args) {
        //System.out.println(getans(3));
        Scanner sc=new Scanner(System.in);
        long m=sc.nextLong();

        String stt=Long.toBinaryString(m);

        //System.out.println(stt);

        StringBuilder sb=new StringBuilder(stt);
        sb.reverse();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                list.add(i);
            }
        }
        if(list.size()!=2){
            System.out.println(-1);
        }else {
            System.out.println(list.get(0)+" "+list.get(1));
        }

//        for(int i=0;i<m;i++){
//            for(int j=0;j<m;j++){
//                if(getans(i)+getans(j)==m){
//                    System.out.println(i+" "+j);
//                    return;
//                }
//            }
//        }
//        System.out.println(-1);
    }
    public static long getans(int m){
        long ret=1;
        for(int i=0;i<m;i++){
            ret=ret*2;
        }
        return ret;
    }
}
