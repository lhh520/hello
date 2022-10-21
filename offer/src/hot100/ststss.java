package hot100;

import java.util.Arrays;
import java.util.*;

public class ststss {
    //6 3
    //8 9 3 5 1 3
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String[]yy=str1.split(" ");
        int n=Integer.parseInt(yy[0]);
        int k=Integer.parseInt(yy[1]);
        String str2=sc.nextLine();
        String[]yy1=str2.split(" ");
        int[]nums=new int[yy1.length];
        for(int i=0;i<yy1.length;i++){
            nums[i]=Integer.parseInt(yy1[i]);
        }
        System.out.println(Arrays.toString(nums));
        if(nums.length==0){
            System.out.println(0);
            return;
        }
        k=Math.min(k,n/2);
        int[][]order1=new int[n][k+1];
        int[][]order2=new int[n][k+1];
        order1[0][0]=-nums[0];
        order2[0][0]=0;
        for(int i=1;i<=k;i++){
            order2[0][i]=Integer.MIN_VALUE/2;
            order1[0][i]=order2[0][i];
        }

        for(int i=1;i<n;i++){
            order1[i][0]=Math.max(order1[i-1][0],order2[i-1][0]-nums[i]);
            for(int j=1;j<=k;j++){
                order1[i][j]=Math.max(order1[i-1][j],order2[i-1][j]-nums[i]);
                order2[i][j]=Math.max(order2[i-1][j],order1[i-1][j-1]+nums[i]);
            }
        }
        System.out.println(Arrays.stream(order2[n-1]).max().getAsInt());
    }
}
