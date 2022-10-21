package hot100;

import java.util.Arrays;
import java.util.*;

public class yeyeye {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        int n=Integer.parseInt(str1);
        String str2=sc.nextLine();
        String[]yy1=str2.split(" ");
        int[]nums=new int[yy1.length];
        for(int i=0;i<yy1.length;i++){
            nums[i]=Integer.parseInt(yy1[i]);
        }
        //System.out.println(Arrays.toString(nums));
        if(nums.length==0){
            System.out.println(0);
            return;
        }
        System.out.println(rob(nums));

    }
    public static int rob(int[]nums){
        int len=nums.length;
        if(len==1){
            return nums[0];
        }else if(len==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(gettob(nums,0,nums.length-2),gettob(nums,1,nums.length-1));
    }
    public static int gettob(int[]nums,int begin,int end){
        int f=nums[begin];
        int s=Math.max(nums[begin],nums[begin+1]);
        for(int i=begin+2;i<=end;i++){
            int temp=s;
            s=Math.max(f+nums[i],s);
            f=temp;
        }
        return s;
    }
}
