package tp101.链表;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class test00001 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]stsr=str.split(" ");
        int n=Integer.parseInt(stsr[0]);
        int m=Integer.parseInt(stsr[1]);
        int id=Integer.parseInt(stsr[2]);
        int[][]ma=new int[n][2];
        for(int i=0;i<n;i++){
            String str11=sc.nextLine();
            String[]stsr1=str11.split(" ");
            int ret=0;
            for(int j=0;j<stsr1.length;j++){
                int cur=Integer.parseInt(stsr1[j]);
                ret+=cur;
            }
            ma[i][0]=i;
            ma[i][1]=ret;
        }
        //System.out.println(1);
        Arrays.sort(ma, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }else {
                    return o2[1]-o1[1];
                }
            }
        });
//        for(int i=0;i<ma.length;i++){
//
//            System.out.println(Arrays.toString(ma[i]));
//        }
        for(int i=0;i<ma.length;i++){
            if(ma[i][0]==id-1){
                System.out.println(i+1);
                return;
            }
        }
    }
}
