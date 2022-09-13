package plan92.yyyy;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int i=0;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                break;
            }
        }
        if(i>=str.length()-1){
            System.out.println(-1);
            return;
        }
        //System.out.println(i);
        int count=0,j=0;
        for(j=i+1;j<str.length();j++){
            char c=str.charAt(j);
            count++;
            if(c!='3'){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
