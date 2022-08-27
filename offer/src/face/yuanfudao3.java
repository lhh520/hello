package face;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class yuanfudao3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String fi=sc.nextLine();
        String[] t1=fi.split(" ");
        int n=Integer.parseInt(t1[0]);
        int m=Integer.parseInt(t1[1]);
        int[][]score=new int[m][2];
        for(int i=0;i<m;i++){
             String str=sc.nextLine();
             String[]str1=str.split(" ");
             score[i][0]=Integer.parseInt(str1[3]);
            score[i][0]=Integer.parseInt(str1[2]);
        }
        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        if(score[0][0]==0){
            System.out.println(1);
        }else {
            System.out.println(score[0][0]);
        }
    }
}
