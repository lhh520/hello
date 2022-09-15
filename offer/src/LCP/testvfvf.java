package LCP;

import java.util.*;

public class testvfvf {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strs=str.split(" ");
        int a=Integer.parseInt(strs[0]);
        int b=Integer.parseInt(strs[1]);
        String sgg=sc.nextLine();
        String[]strs1=sgg.split(" ");
        int[]nums=new int[strs1.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(strs1[i]);
        }
        //System.out.println(Arrays.toString(nums));
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>b){
                count++;
            }
        }
        System.out.println(count);
    }
}
