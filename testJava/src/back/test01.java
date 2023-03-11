package back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int index=0;
        List<Integer>list=new ArrayList<>();
        while (index<s.length()){
            char cur=s.charAt(index);
            int len=0;
            while (index<s.length()&&s.charAt(index)==cur){
                len++;
                index++;
            }
            list.add(len);
        }
        int count=0;
        //System.out.println(list.toString());
        for(int i=0;i<list.size();i++){
            int cur=list.get(i);
            if(cur==1){
                continue;
            }
            if(cur%2==0){
                count+=cur/2;
            }else {
                count+=(cur-1)/2;
            }
        }
        System.out.println(count);
    }
}
