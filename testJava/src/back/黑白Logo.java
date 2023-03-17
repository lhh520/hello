package back;

import java.util.Scanner;

public class 黑白Logo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String[]ss=s1.split(" ");
        int n=Integer.parseInt(ss[0]);
        int q=Integer.parseInt(ss[1]);
        String[]ss2=s2.split(" ");
        int[]qu=new int[ss2.length];
        for(int i=0;i<ss2.length;i++){
            qu[i]=Integer.parseInt(ss2[i]);
        }
        System.out.println("BBWB");
        System.out.println("BBBW");
        System.out.println("WBBB");
        System.out.println("BWBB");
    }
    //BBWB
    //BBBW
    //WBBB
    //BWBB
}
