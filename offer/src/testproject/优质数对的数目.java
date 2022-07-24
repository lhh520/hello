package testproject;

import org.junit.Test;

import java.util.*;

public class 优质数对的数目 {
    public long countExcellentPairs(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(set.add(nums[i])){
                list.add(nums[i]);
            }
        }
        long count=0L;
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(isflag(list.get(i),list.get(j),k)){
                    count+=1;
                }
            }
        }
        return count;
    }
    boolean isflag(int i,int j,int k){
        int m=i&j;
        int n=i|j;
        char[]char1=Integer.toBinaryString(m).toCharArray();
        char[]char2=Integer.toBinaryString(n).toCharArray();
        int count=0;
        //System.out.println(1);
        for(int ii=0;ii<char1.length;ii++){
            if(char1[ii]=='1'){
                count++;
            }
        }
        for(int ii=0;ii<char2.length;ii++){
            if(char2[ii]=='1'){
                count++;
            }
        }
        if(count>=k)
            return true;
        return false;
    }
    public long countExcellentPairs1(int[] nums, int k){
        int[]bitcnt=new int[30];
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            if(set.add(num)){
                bitcnt[Integer.bitCount(num)]++;//bit[15]++ 表示存在一个数字数字的个数是15
            }
        }
        long res=0;
        for(int i=0;i<=29;i++){
            for(int j=Math.max(0,k-i);j<=29;j++){
                res+=bitcnt[i]*bitcnt[j];
            }
        }
        return res;
    }


    @Test
    public void test(){
        //nums = [1,2,3,1], k = 3
        int[]nums=new int[]{1,2,3,1};
        //System.out.println(isflag(3,3,3));
        System.out.println(countExcellentPairs1(nums,3));
    }
}
