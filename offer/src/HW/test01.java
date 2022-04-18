package HW;

import java.util.Scanner;

public class test01 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            if(m==0)
                return;
            if(m<=1)
                System.out.println(1);
            int sum=0;
            while(m>=3){
                sum=sum+m/3;
                m=m%3+m/3;

            }
            if(m==2)
            System.out.println(sum+1);
            else
                System.out.println(sum);
        }
    }
}
