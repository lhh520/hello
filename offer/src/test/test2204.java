package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test2204 {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums,0);
        HashMap<Integer,Integer>map=new HashMap<>();
        int bb=Integer.MIN_VALUE;
        for(List<Integer>temp:lists){
            if(temp.size()>0){
                if(temp.size()==1){
                    map.put(temp.get(0),map.getOrDefault(temp.get(0),0)+1);
                    bb=Math.max(bb,temp.get(0));
                }else{
                    int a = 0;
                    for (int i = 0; i <temp.size(); i++) {
                        a=a|temp.get(i);
                    }
                    map.put(a,map.getOrDefault(a,0)+1);
                    bb=Math.max(bb,a);
                }
            }

        }

        return map.get(bb);
    }
    void dfs(int[] nums,int index){
        if(index>=nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums,index+1);
        list.remove(list.size()-1);
        dfs(nums,index+1);
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,1,5};
        int a=countMaxOrSubsets(nums);
        //先求得所有的子集
        System.out.println(a);
    }
}
