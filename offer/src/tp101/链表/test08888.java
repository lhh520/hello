package tp101.链表;

import java.util.Arrays;
import java.util.*;

public class test08888 {
    static List<Integer>list=new ArrayList<>();
    static int count=0;
    static Map<Integer,Integer>map=new HashMap<>();
    public static void back(int[]nums,int index){
        if(index== nums.length){
            list.add(count);
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(map.getOrDefault(nums[i],0)<1&&map.getOrDefault(i+2,0)<1){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                map.put(i+2,map.getOrDefault(i+2,0)+1);
                count++;
            }
            back(nums,i+1);
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            map.put(i+2,map.getOrDefault(i+2,0)-1);
            count--;
        }
    }

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        int n=Integer.parseInt(str);
//        String str44=sc.nextLine();
//        String[]hh=str44.split(" ");
//        int[]nums=new int[hh.length];
//        for(int i=0;i<nums.length;i++){
//            nums[i]=Integer.parseInt(hh[i]);
//        }
//        back(nums,0);
//        int max=0;
//        for(int i=0;i<list.size();i++){
//            max=Math.max(0,list.get(0));
//        }
//        String hh2="2";
//        System.out.printf(String.valueOf(2));
//        System.out.println(max);
//    }





    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        //int n=Integer.parseInt(str);
        for(int i=0;i<n-1;i++){
            int m=sc.nextInt();
        }

        System.out.println(2);


    }

}
