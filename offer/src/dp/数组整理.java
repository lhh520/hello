package dp;

import java.util.Arrays;
import java.util.*;

public class 数组整理 {
    public static void main(String[] args) {
        //[1, 1, 2, 2, 3]
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(str.charAt(0)=='[')
        str=str.substring(1,str.length()-1);

        System.out.println(str);
        String[]ar=str.split(",");
        int[]nums=new int[ar.length];
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(ar[i]);
            set.add(nums[i]);
        }
        int[]hu=new int[set.size()];
        int i=0;
        for(int num:set){
            hu[i++]=num;
        }
        System.out.println(Arrays.toString(hu));
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int ii=0;ii<hu.length;ii++){
            sb.append(hu[ii]);
            if(ii!=hu.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
