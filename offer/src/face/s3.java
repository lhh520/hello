package face;

import java.util.Scanner;

public class s3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        String[]strs=ss.substring(1,ss.length()-1).split(",");
        int[]nums=new int[strs.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        int max=0;
        int i=0,j=nums.length-1;
        while (i<j){
            max=Math.max(max,(j-i)*Math.min(nums[i],nums[j]));
            if(nums[i]<nums[j]){
                i++;
            }else {
                j--;
            }
        }
        System.out.println(max);
    }
}
