package tp101.链表;

import java.util.*;

public class test08 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] in=sc.nextLine().split(" ");
        int n=Integer.parseInt(in[0]);
        int b=Integer.parseInt(in[1]);
        String big=sc.nextLine();

        String[] elecstr=big.split(" ");
        int[]ele=new int[elecstr.length];
        for(int i=0;i<elecstr.length;i++){
            ele[i]=Integer.parseInt(elecstr[i]);
        }

        String small=sc.nextLine();

        String[] clostr=big.split(" ");
        int[]clo=new int[clostr.length];
        for(int i=0;i<clostr.length;i++){
            clo[i]=Integer.parseInt(clostr[i]);
        }

        System.out.println(-1);

    }
}
