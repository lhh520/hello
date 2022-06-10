package testproject;

import org.junit.Test;

import java.util.*;

public class 两个列表的最小索引总和 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        List<String>love=new ArrayList<>();
        int index=Integer.MAX_VALUE;
        for(int j=0;j<list2.length;j++){
            if(map.containsKey(list2[j])){
            if(index>(map.get(list2[j])+j)){
                love.clear();
                love.add(list2[j]);
                index=map.get(list2[j])+j;
            }else if(index==(map.get(list2[j])+j)){
                love.add(list2[j]);
            }
            }
        }
        String[]strs=new String[love.size()];
        for(int i=0;i<strs.length;i++){
            strs[i]=love.get(i);
        }
        return strs;
    }
    @Test
    public void test(){
        String[]list1 =new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[]list2 =new String[]{"KFC","Shogun","Burger King"};
        String[] strs=findRestaurant(list1,list2);
        System.out.println(Arrays.toString(strs));

    }
}
