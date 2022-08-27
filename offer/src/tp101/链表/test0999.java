package tp101.链表;

import java.util.Locale;
import java.util.*;

public class test0999 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n1=sc.nextLine();
        String[]nn=n1.split(" ");
        int n=Integer.parseInt(nn[0]);
        int k=Integer.parseInt(nn[1]);
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        String s1=str.substring(0,k).toUpperCase(Locale.ROOT);
        String s2=str.substring(k).toLowerCase(Locale.ROOT);
        System.out.println(s1+s2);
    }
}
