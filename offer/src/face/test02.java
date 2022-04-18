package face;

import java.util.Arrays;
import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n;
        while (in.hasNext())
        {
            String passWo=in.nextLine();
            n=0;
            System.out.println(getScore(passWo,n));
        }

    }
    public static int getScore(String password,int sc)
    {   int sum=0;
        int n1=0,n2=0,n3=0,n4=0,n5=0;
        int len=password.length();
        if(len<=4)
            n1=5;
        else if(len>=5&&len<=7)
            n1=10;
        else n1=25;
        boolean flag1= false,flag2 = false,flag3= false,flag4= false;
        int count=0;
        int count2=0;
        for (int i = 0; i < password.length(); i++) {
            char c=password.charAt(i);
            if (Character.isLowerCase(c))
               flag1=true;
            if (Character.isUpperCase(c))
                flag2=true;
            if(Character.isDigit(c))
            {   flag3=true;
                count++;
            }
            if(!Character.isLowerCase(c)&&!Character.isUpperCase(c)&&!Character.isDigit(c))
            {   flag4=true;
                count2++;
            }
        }
        if(flag1&&flag2)
            n2=25;
        if(flag1&&flag2)
            n2=10;
        if(count==1||count==2)
            n3=10;
        if(count>=3)
            n3=20;
        //
        if(count2==1)
            n4=10;
        if(count>=2)
            n4=20;
        if(flag1&&flag2&&flag3&&flag4)
            n5=10;
        else if((flag1||flag2)&&flag3&&flag4)
            n5=5;
        else if((flag1||flag2)&&flag3)
            n5=2;
        sum=n1+n2+n3+n4+n5;
        return sum;
    }
}
