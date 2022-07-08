package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 得到子序列的最小操作次数 {
    public int minOperations(int[] target, int[] arr){
        int n=target.length;
        Map<Integer,Integer>pos=new HashMap<>();
        //先将target映射到哈希表中
        for(int i=0;i<n;i++){
            pos.put(target[i],i);
        }
        List<Integer>d=new ArrayList<>();
        for(int val:arr){
            if(pos.containsKey(val)){
                int idx=pos.get(val);//找到
                int it=binarySearch(d,idx);
                if(it!=d.size()){
                    d.set(it,idx);
                }else {
                    d.add(idx);
                }
            }
        }
        return n-d.size();
    }
    public int binarySearch(List<Integer>d,int target){
        int size=d.size();
        if(size==0||d.get(size-1)<target){
            return size;
        }
        int low=0,high=size-1;
        while (low<high){
            int mid=(high-low)/2+low;
            if(d.get(mid)<target){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low;
    }
    @Test
    public void test(){
        int[]target =new int[]{5,1,3};
        int[]arr =new int[]{9,4,2,3,4};
        System.out.println(minOperations(target,arr));
    }
}
