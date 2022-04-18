package HW;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String low=scanner.nextLine();
        System.out.println(low);
        int sum=0;
        for(int i=2;i<low.length();i++){
            char c=low.charAt(i);
            if(c>='0'&&c<='9')
                sum=sum*16+c-'0';
            if(c>='A'&&c<='F')
                sum=sum*16+10+(c-'A');
        }
        System.out.println(sum);
        scanner.close();
    }
}
