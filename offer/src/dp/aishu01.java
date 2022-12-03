package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class aishu01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]ss=str.split(",");
        int[]nums=new int[ss.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(ss[i]);
        }
        int pre=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i< nums.length;i++){
            pre+=nums[i];
            if(map.containsKey(pre)){
                count+=map.get(pre);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        System.out.println(count);
    }
    //

}
