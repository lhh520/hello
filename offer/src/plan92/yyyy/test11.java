package plan92.yyyy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class test11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String str=sc.nextLine();
        String[]strings=str.split(" ");
        int[]nums=new int[strings.length];
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
            list.add(Integer.parseInt(strings[i]));
        }
        //System.out.println((int)Math.ceil(n/2));
        Arrays.sort(nums);
        //差值数组
        int[]chazhi=new int[n-1];
        for(int i=1;i<nums.length;i++){
            chazhi[i-1]=nums[i]-nums[i-1];
        }
        //System.out.println(Arrays.toString(chazhi));
        int i=0;
        int count=0;
        while (i+2<nums.length){
            if(i+2< nums.length-1&&nums[i+2]-nums[i]<=10){
                i+=3;
                count++;
            }else if(i+1< nums.length-1&&nums[i+1]-nums[i]<=20){
                i+=2;
                count++;
            }else {
                i+=1;
                count++;
            }
        }
        if(nums[nums.length-1]> nums[nums.length-2]+10){
            System.out.println(count+2);
        }
        System.out.println(count+1);
    }
}
