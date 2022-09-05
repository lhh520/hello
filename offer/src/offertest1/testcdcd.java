package offertest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class testcdcd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String str1=sc.nextLine();
        String[]str11=str1.split(" ");
        int[]num1=new int[str11.length];
        for(int i=0;i<num1.length;i++){
            num1[i]=Integer.parseInt(str11[i]);
        }
        String str2=sc.nextLine();
        String[]str12=str2.split(" ");
        int[]num2=new int[str12.length];
        for(int i=0;i<num2.length;i++){
            num2[i]=Integer.parseInt(str12[i]);
        }

        String str3=sc.nextLine();
        String[]str13=str3.split(" ");
        int[]num3=new int[str13.length];
        for(int i=0;i<num3.length;i++){
            num3[i]=Integer.parseInt(str13[i]);
        }
        List<Integer>list=new ArrayList<>();

        for(int i=0;i<num1.length;i++){
            int L=num1[i],R=num2[i],k=num3[i];
            int ret=0;
            for(int p=L;p<=R;p++){
                if(getnum(p)==num3[i]){
                    ret++;
                }
            }
            list.add(ret);
        }





        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    static int getnum(int num){
        int tmp=0;
        List<Integer>list=new ArrayList<>();
        while (num!=0){
            tmp=num%10;
            list.add(tmp);
            num/=10;
        }
        Collections.reverse(list);
        //System.out.println(list);
        if(list.size()>0){
            tmp=list.get(0);
        }else {
            return 0;
        }

        for(int i=1;i<list.size();i++){
            tmp^=list.get(i);
        }
        return tmp;
    }
}
