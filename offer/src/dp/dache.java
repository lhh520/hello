package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dache {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        List<Integer>list=new ArrayList<>();
        if(m<=4){
            list.add(m);
            System.out.println(list);
            return;
        }
        while (m>=4){
            m=m-4;
            list.add(4);
        }
        if(m==4){
            list.add(4);
        }else if(m==3){
            list.add(3);
        }else if(m==2){
            list.set(list.size()-1,3);
            list.add(3);
        }else if(m==1){
            list.set(list.size()-1,3);
            list.add(2);
        }
        System.out.println(list);
    }
}
