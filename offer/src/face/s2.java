package face;
import org.junit.Test;

import java.util.*;
public class s2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        String[]strs=ss.substring(1,ss.length()-1).split(",");
        int[]nums=new int[strs.length];

        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                max=Math.max(max,Math.abs(j-i)*Math.min(nums[i],nums[j]));
            }
        }
        System.out.println(max);
    }

}
