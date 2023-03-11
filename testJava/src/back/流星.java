package back;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 流星 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String[]ss1=s1.split(" ");
        String[]ss2=s2.split(" ");
        int[]nums1=new int[n];
        int[]nums2=new int[n];
        for(int i=0;i<ss1.length;i++){
            nums1[i]=Integer.parseInt(ss1[i]);
        }
        int max=0;
        for(int i=0;i<ss2.length;i++){
            nums2[i]=Integer.parseInt(ss2[i]);
            max= Arrays.stream(nums2).max().getAsInt();
        }
        int[]nums=new int[max+1];
        for(int i=0;i<n;i++){
            int ii=nums1[i];
            int jj=nums2[i];
            for(int mm=ii;mm<=jj;mm++){
                nums[mm]++;
            }
        }
        int maxx=Arrays.stream(nums).max().getAsInt();
        if(maxx>100000){
            System.out.println(0);
            System.exit(0);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxx){
                count++;
            }
        }
        System.out.println(maxx+" "+count);
    }
}
