package offertest1;

import java.util.*;

public class test098d9d {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]nn=str.split(" ");
        int n=Integer.parseInt(nn[0]);
        int k=Integer.parseInt(nn[1]);
        int t=Integer.parseInt(nn[2]);
        int j=0,i=0,m=0;
        if(n-k*t<t-1){
            System.out.println(-1);
            return;
        }
        Random d=new Random(10003);
        System.out.println(d.nextInt());
        boolean flag=true;
        StringBuilder sb=new StringBuilder();
        StringBuilder tmp=new StringBuilder();
        int to=k/t;
        for(int kk=0;kk<to;kk++){
            tmp.append("1");
        }
        StringBuilder tmp1=new StringBuilder();
        boolean yyy=true;
        if(k-to*k!=0){
            for(int kk=0;kk<k-to*t;kk++){
                tmp1.append("1");
            }
            yyy=false;
        }

        System.out.println(tmp);
        System.out.println(tmp1);
        while(j<n){
            if(m%2==0&&i<t&&flag){
                if(yyy&&i==t-1){
                    sb.append(tmp1.toString());

                }else {
                    sb.append(tmp.toString());
                }
                j+=k;
                m++;
                i++;
                flag=false;
            }else {
                sb.append("0");
                j+=1;
                m++;
                flag=true;
            }
        }
        System.out.println(sb.toString());
    }
}
