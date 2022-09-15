package LCP;

import java.util.Arrays;
import java.util.*;

public class test887 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        int n=Integer.parseInt(str);
//        String str1=sc.nextLine();
//        String[]strs1=str1.split(" ");
//        int[]nums1=new int[strs1.length];
//        for(int i=0;i<strs1.length;i++){
//            nums1[i]=Integer.parseInt(strs1[i]);
//        }
//        //System.out.println(Arrays.toString(nums1));
//        String str2=sc.nextLine();
//        String[]strs2=str2.split(" ");
//        int[]nums2=new int[strs2.length];
//        for(int i=0;i<strs2.length;i++){
//            nums2[i]=Integer.parseInt(strs2[i]);
//        }
//        //System.out.println(Arrays.toString(nums2));
//        int[][]dp=new int[n][3];
//        dp[0][0]=0;
//        dp[0][1]=nums1[0];
//        dp[0][2]=nums2[0];
//
//        if(n==1){
//            System.out.println(Math.max(nums1[0],nums2[0]));
//            return;
//        }
//
//
//        for(int i=1;i<n;i++){
//            dp[i][0]=Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][0]));
//            dp[i][1]=Math.max(dp[i-1][0]+nums1[i],dp[i-1][2]+nums1[i]);
//            dp[i][2]=Math.max(dp[i-1][0]+nums2[i],dp[i-1][1]+nums2[i]);
//        }
//
//        int max=0;
//        max=Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
//        System.out.println(max);
//    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    int n=Integer.parseInt(str);
    String str1=sc.nextLine();
    String[]strs1=str1.split(" ");
    int[]nums1=new int[strs1.length];
    for(int i=0;i<strs1.length;i++){
        nums1[i]=Integer.parseInt(strs1[i]);
    }
    //System.out.println(Arrays.toString(nums1));
    String str2=sc.nextLine();
    String[]strs2=str2.split(" ");
    int[]nums2=new int[strs2.length];
    for(int i=0;i<strs2.length;i++){
        nums2[i]=Integer.parseInt(strs2[i]);
    }
    //System.out.println(Arrays.toString(nums2));
    long[][]dp=new long[n][3];
    dp[0][0]=0;
    dp[0][1]=nums1[0];
    dp[0][2]=nums2[0];

    if(n==1){
        System.out.println(Math.max(nums1[0],nums2[0]));
        return;
    }


    for(int i=1;i<n;i++){
        dp[i][0]=Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][0]));
        dp[i][1]=Math.max(dp[i-1][0]+nums1[i],dp[i-1][2]+nums1[i]);
        dp[i][2]=Math.max(dp[i-1][0]+nums2[i],dp[i-1][1]+nums2[i]);
    }

    long max=0;
    max=Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
    System.out.println(max);
}
}
