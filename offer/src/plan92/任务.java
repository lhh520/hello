package plan92;

import java.util.Arrays;
import java.util.*;

public class 任务 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String[]strings=s1.split(" ");
        int n=Integer.parseInt(strings[0]);
        int m=Integer.parseInt(strings[1]);
        int k=Integer.parseInt(strings[2]);
        String s2=scanner.nextLine();
        String[]strings1=s2.split(" ");
        int[]city=new int[strings1.length];
        for(int i=0;i<city.length;i++){
            city[i]=Integer.parseInt(strings1[i]);
        }
        //
        String s3=scanner.nextLine();
        String[]strings2=s3.split(" ");
        int[]score1=new int[strings1.length];
        for(int i=0;i<city.length;i++){
            score1[i]=Integer.parseInt(strings2[i]);
        }
        String s4=scanner.nextLine();
        String[]strings3=s4.split(" ");
        int[]score2=new int[strings1.length];
        for(int i=0;i<city.length;i++){
            score2[i]=Integer.parseInt(strings3[i]);
        }
        int ret=0;
        for(int i=0;i<city.length;i++){
             if(city[i]==k){
                 ret+=score1[i];
             }else {
                 if(i<city.length-1&&score2[i]>score1[i+1]){
                     ret+=score2[i];
                     k=city[i];
                 }else {
                     ret+=0;
                 }
             }
        }
        System.out.println(ret);
    }
}
