package mei01;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        int n=Integer.parseInt(nn);

        String s1=sc.nextLine();
        String s2=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
