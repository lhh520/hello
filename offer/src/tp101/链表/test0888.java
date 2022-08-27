package tp101.链表;

import java.util.*;

public class test0888 {
    public static void main(String[] args) {
        int mod=1000000000+7;
        Scanner sc=new Scanner(System.in);
        String n1=sc.nextLine();
        int m=Integer.parseInt(n1);
        if(m<3){
            System.out.println(0);
            return;
        }
        if(m<6){
            System.out.println(1);
            return;
        }
        int l1=(m-5)+((m-5)*(m-6))/2;

        System.out.println(l1);
    }
}
