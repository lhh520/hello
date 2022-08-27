package tp101.链表;

//import java.util.Arrays;
import java.util.*;

public class test0533 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n1=sc.nextLine();
        String nn2=sc.nextLine();
        String[]bb=nn2.split(" ");
        int[]nums=new int[bb.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(bb[i]);
        }

        System.out.println(Arrays.toString(nums));
        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();

        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();

        int max1=0,max2=0,ch=-1,ch2=-1;
        for(int i=0;i< nums.length;i++){
             if(i%2==0){
                 map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
                 if(map1.get(nums[i])>max1){
                     max1=map1.get(nums[i]);
                     ch=nums[i];
                 }

             }else {
                 map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
                 if(map2.get(nums[i])>=max2){
                     max2=map2.get(nums[i]);
                     ch2=nums[i];
                 }
             }
        }

        int ret=0;
        if(ch!=ch2){
            for(int i=0;i< nums.length;i++){
                if(i%2==0){
                    if(nums[i]!=ch){
                        ret++;
                    }
                }else {
                    if(nums[i]!=ch2){
                        ret++;
                    }
                }
            }
        }

        System.out.println(ret);
    }
}
