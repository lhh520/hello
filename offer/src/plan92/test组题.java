package plan92;

import java.util.Arrays;
import java.util.Scanner;

public class test组题 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        int[]nums1=new int[n];
        int[]nums2=new int[n];
        int[]nums3=new int[n];

        String str1=sc.nextLine();
        String[]strings=str1.split(" ");
        for(int i=0;i<n;i++){
            nums1[i]=Integer.parseInt(strings[i]);
        }
        String str2=sc.nextLine();
        String[]strings2=str2.split(" ");
        for(int i=0;i<n;i++){
            nums2[i]=Integer.parseInt(strings2[i]);
        }
        String str3=sc.nextLine();
        String[]strings3=str3.split(" ");
        for(int i=0;i<n;i++){
            nums3[i]=Integer.parseInt(strings3[i]);
        }
        int ret=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                for(int k=0;k<nums3.length;k++){
                    if(nums2[j]>nums1[i]&&nums2[j]<=2*nums1[i]&&nums3[k]>nums2[j]&&nums3[k]<=2*nums2[j]){
                        ret++;
                    }
                }
            }
        }
        System.out.println(ret);

    }
}
