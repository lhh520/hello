package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 找出数组中的幸运数 {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            if(map.get(arr[i])==arr[i]){
                return arr[i];
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[]arr=new int[]{2,2,3,4};
        System.out.println(findLucky(arr));
    }
}
