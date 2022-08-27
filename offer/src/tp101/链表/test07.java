package tp101.链表;

import java.util.*;

public class test07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] in=sc.nextLine().split(" ");
        int n=Integer.parseInt(in[0]);
        int m=Integer.parseInt(in[1]);
        String big=sc.nextLine();

        String[] next=sc.nextLine().split(" ");
        String[] small=new String[m];
        for(int i=0;i<m;i++){
            small[i]=sc.nextLine();
        }

    }
}
