package hot100;

import java.util.*;

public class testdddd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String strs=sc.nextLine();
        String[]hhh=strs.split(" ");
        int[]nums=new int[n];
        int[]nums0=new int[n];
        int[]nums1=new int[n];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(hhh[i]);
            nums0[i]=nums[i]-1;
            nums1[i]=nums[i]+1;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            map.put(nums0[i],map.getOrDefault(nums0[i],0)+1);
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int max=0;
        int value=0;
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(max<entry.getValue()){
                max=entry.getValue();
                value=entry.getKey();
            }
        }
//        System.out.println(value);
//        System.out.println(max);

    }
}
