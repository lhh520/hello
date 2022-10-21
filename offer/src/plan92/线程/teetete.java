package plan92.线程;

import java.util.*;

public class teetete {
    public static int minMoves(int m, int n) {
        int a = 0;
        int b = 0;

        while (n>0 && m >1) {
            if(m % 2 == 1) {
                a++;
            }

            m /=2;
            b++;
            n--;
        }


        if(m >1) {
            a +=m-1;
        }

        return a + b;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]yy=str.split(",");
        int m=Integer.parseInt(yy[0]);
        int n=Integer.parseInt(yy[1]);
        int a = 0;
        int b = 0;

        while (n>0 && m >1) {
            if(m % 2 == 1) {
                a++;
            }

            m /=2;
            b++;
            n--;
        }


        if(m >1) {
            a +=m-1;
        }

        System.out.println(a+b);
    }


}
