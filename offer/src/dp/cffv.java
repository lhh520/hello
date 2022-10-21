package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class cffv {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[][]matrix=new int[n][n];
        int nn=0;
        while (n-->0){
            String curLine=sc.nextLine();
            String[]temp=curLine.split(" ");
            for(int ii=0;ii<temp.length;ii++){
                matrix[nn][ii]=Integer.parseInt(temp[ii]);
            }
            nn++;
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int one=0,zero=0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    zero++;
                }else {
                    one++;
                }
            }
            if(one>zero){
                list.add(i+1);
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(" ");
            }
        }
        //System.out.println(list);
    }
}
