package LCP;

import java.util.Arrays;
import java.util.*;

public class test0333 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        String[]strs=str.split(" ");
//        int n=Integer.parseInt(strs[0]);
//        int m=Integer.parseInt(strs[1]);
//        int t=Integer.parseInt(strs[2]);
//        String str1=sc.nextLine();
//        String[]strs1=str1.split(" ");
//        int[]nums1=new int[strs1.length];
//        for(int i=0;i<strs1.length;i++){
//            nums1[i]=Integer.parseInt(strs1[i]);
//        }
//        String str2=sc.nextLine();
//        String[]strs2=str2.split(" ");
//        int[]nums2=new int[strs2.length];
//        for(int i=0;i<strs2.length;i++){
//            nums2[i]=Integer.parseInt(strs2[i]);
//        }
//
//        int[]pre1=new int[nums1.length+1];
//        for(int i=1;i<=nums1.length;i++){
//            pre1[i]+=pre1[i-1]+nums1[i-1];
//        }
//        int[]pre2=new int[nums2.length+1];
//        for(int i=1;i<=nums2.length;i++){
//            pre2[i]+=pre2[i-1]+nums2[i-1];
//        }
//        int max=0;
//        for(int i=0;i<pre1.length;i++){
//            for(int j=0;j< pre2.length;j++){
//                if(pre1[i]+pre2[j]<=t){
//                     max=Math.max(i+j,max);
//                }
//            }
//        }
//        System.out.println(max);
//    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    String[]strs=str.split(" ");
    int n=Integer.parseInt(strs[0]);
    int m=Integer.parseInt(strs[1]);
    int t=Integer.parseInt(strs[2]);
    String str1=sc.nextLine();
    String[]strs1=str1.split(" ");
    int[]nums1=new int[strs1.length];
    for(int i=0;i<strs1.length;i++){
        nums1[i]=Integer.parseInt(strs1[i]);
    }
    String str2=sc.nextLine();
    String[]strs2=str2.split(" ");
    int[]nums2=new int[strs2.length];
    for(int i=0;i<strs2.length;i++){
        nums2[i]=Integer.parseInt(strs2[i]);
    }

    long[]pre1=new long[nums1.length+1];
    for(int i=1;i<=nums1.length;i++){
        pre1[i]+=pre1[i-1]+nums1[i-1];
    }
    long[]pre2=new long[nums2.length+1];
    for(int i=1;i<=nums2.length;i++){
        pre2[i]+=pre2[i-1]+nums2[i-1];
    }
    long max=0;
    for(int i=0;i<pre1.length;i++){
        for(int j=0;j< pre2.length;j++){
            if(pre1[i]+pre2[j]<=t){
                max=Math.max(i+j,max);
            }
        }
    }
    System.out.println(max);
}
}
