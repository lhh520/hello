package tp101.链表;

import java.util.*;

public class test04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in=sc.nextLine();
        String[]nnn=in.split(" ");
        int n1=Integer.parseInt(nnn[0]),n2=Integer.parseInt(nnn[1]);
        String t=sc.nextLine();
        String s=sc.nextLine();
        int ret=0;
        for(int i=0;i<t.length()-s.length()+1;i++){
            String ss=t.substring(i,i+s.length());
            //System.out.println(ss);
            int count=0,len=0;
            for(int j=0;j<ss.length();j++){
                if(ss.charAt(j)!=s.charAt(j)){
                    count++;
                    len=j;
                }
            }
            if(count==1&&s.charAt(len)=='*'){

                ret++;
            }
        }
        System.out.println(ret);
    }
}
