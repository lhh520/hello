package face;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Scanner;

public class yufang2 {
    /*
    * 2
20 8
1 2 3 2 6 5 2 1
17 10
1 4 5 7 10 8 7 17 2 8*/

    public int gset(int[]nums,int num){
        List<Integer>ans=new ArrayList<>();
        for(int i=2;i<=num;i++){
            while (num%i==0){
                ans.add(i);
                num=num/i;
            }
        }
        return minwindow(nums,ans);
    }
    public int minwindow(int[]s,List<Integer>t){
        int left=0,right=0;
        int start=0;
        int len=Integer.MAX_VALUE,value=0;
        Map<Integer,Integer>window=new HashMap<>(),need=new HashMap<>();
        for(int c:t){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        while (right<s.length){
            int c=s[right];
            ++right;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c)==need.get(c)){
                    ++value;
                }
            }
            while (value==need.size()){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }
                int p=s[left];
                ++left;
                if(need.containsKey(p)){
                    if(window.get(p)==need.get(p)){
                        value--;
                    }
                    window.put(p,window.getOrDefault(p,0)-1);
                }

            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
    @Test
    public void test(){
        Scanner sc=new Scanner(System.in);
        String fi=sc.nextLine();
        int m=Integer.parseInt(fi);
        for(int i=0;i<m;i++){
            String t1=sc.nextLine();
            String[] tt1=t1.split(" ");
            int mm=Integer.parseInt(tt1[0]);
            int nn=Integer.parseInt(tt1[1]);//8
            String t2=sc.nextLine();
            String[] tt2=t1.split(" ");
            int[]nums=new int[nn];
            for(int ii=0;ii<nn;ii++){
                nums[ii]=Integer.parseInt(tt2[i]);
            }
            int mms=gset(nums,mm);
            System.out.println(mms);
        }
    }
//    public static void main(String[] args) {
//
//    }







}
