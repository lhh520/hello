package offertest1;

import org.junit.Test;

import java.util.*;

public class offer44 {
    public String minNumber(int[] nums) {
        List<Integer>list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1.toString();
                String s2=o2.toString();
                int i=0,j=0;
                while (i<s1.length()||j<s2.length()){
                   int num1= i>=s1.length()?0:Integer.valueOf(s1.charAt(i));
                   int num2= j>=s2.length()?0:Integer.valueOf(s2.charAt(j));
                   if(num1>num2){
                       return 1;
                   }
                   if(num1<num2)
                       return -1;
                   i++;
                   j++;
                }
                return s1.length()> s2.length()?1:-1;

            }
        });
        System.out.println(list.toString());
        return "hello";
    }
    @Test
    public void test(){
        int[] nums=new int[]{3,30,34,5,9};
        System.out.println(minNumber(nums));
    }
}
