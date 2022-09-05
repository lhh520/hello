package offertest1;
import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.*;
public class test0999 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]nn=str.split(" ");
        int n=Integer.parseInt(nn[0]);
        int k=Integer.parseInt(nn[1]);
        String str1=sc.nextLine();
        String[]nn1=str1.split(" ");
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(nn1[i]);
        }
        //System.out.println(Arrays.toString(nums));
        int[]yy=new int[k];
        for(int i=0;i<n;i++){
            yy[nums[i]%k]++;
        }
        //System.out.println(Arrays.toString(yy));
        int max=0;
        for(int i=0;i<k;i++){
            max=Math.max(max,yy[i]);
        }
        System.out.println(max);
    }


}
