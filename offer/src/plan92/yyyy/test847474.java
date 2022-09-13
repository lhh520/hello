package plan92.yyyy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;

public class test847474 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        String str=sc.nextLine();
        String[]str1=str.split(" ");
        int n=str1.length;
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(str1[i]);
        }
        //System.out.println(Arrays.toString(nums));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int cur=0;
        int[]ret=new int[n+1];
        for(int i=0;i< nums.length;i++){
            if(cur+1!=nums[i]){
                pq.add(nums[i]);
            }else {
                pq.add(nums[i]);
                while (!pq.isEmpty()&&pq.peek()==cur+1){
                    ret[pq.peek()]=i+1;
                    pq.poll();
                    cur++;
                }
            }

        }
        for(int i=1;i< ret.length;i++){
            System.out.print(ret[i]);
            if(i!=ret.length-1)
            System.out.print(" ");
        }

    }
}
