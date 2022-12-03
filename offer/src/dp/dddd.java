package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class dddd {
    static List<String>list=new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println("");
            return;
        }
        backtrace(0,0,n,new StringBuilder());
        //System.out.println(list);
        //Collections.sort(list);
        System.out.print("[");
        for(int i=0;i<list.size();i++){
            System.out.print("'"+list.get(i)+"'");
            if(i!=list.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    public static void backtrace(int left,int right,int n,StringBuilder sb){
        if(left>n||right>left||right>n){
            return;
        }
        if(left==right&&left==n){
            list.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            backtrace(left+1,right,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrace(left,right+1,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
