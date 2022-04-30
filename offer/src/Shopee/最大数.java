package Shopee;

import org.junit.Test;

import java.util.*;

public class 最大数 {
    public String largestNumber(int[] nums) {
        StringBuffer sb1=new StringBuffer();
        for(int i=0;i<nums.length;i++){
            sb1.append(nums[i]);
        }
        try {
            int nn=Integer.parseInt(sb1.toString());
            if(nn==0)
                return "0";
        }catch (Exception e){

        }

        Integer[] nu=new Integer[nums.length];
       for(int i=0;i<nums.length;i++){
           nu[i]=new Integer(nums[i]);
       }
       Arrays.sort(nu, new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               String str1=o1.toString();
               String str2=o2.toString();
               int i=0,j=0;
               while(i<str1.length()||j<str2.length()){
                   String t1= Integer.toString(o1);
                   String t2= Integer.toString(o2);
                   return (t2+t1).compareTo(t1+t2);
               }
               return 0;
           }
       });
        //System.out.println(Arrays.toString(nu));
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<nu.length;i++){
            sb.append(nu[i].toString());
        }
        return sb.toString();
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,0};
        System.out.println(largestNumber(nums));
    }
}
