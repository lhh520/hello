package dp;

import java.util.Arrays;
import java.util.Scanner;

public class 超过一半的数字 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[]ss=s.split(",");
        int[]nums=new int[ss.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(ss[i]);
        }
        Arrays.sort(nums);
        int mid=nums[nums.length/2];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==mid){
                count++;
            }
        }
        if(count>nums.length/2){
            System.out.println(mid);
        }else {
            System.out.println(0);
        }
    }
}
