package plan92;

import java.util.*;

public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]tsr=str.split(" ");
        int a=Integer.parseInt(tsr[0]);
        int b=Integer.parseInt(tsr[1]);
        if(a>=1&&b<=a-2){
            System.out.println(0);
        }else if(a>=1&&b>a-2){
            System.out.println(b-a+2);
        }else if(b<=9){
            System.out.println(11-a);
        }else if(b>9){
            System.out.println(b+2-a);
        }
    }
}
