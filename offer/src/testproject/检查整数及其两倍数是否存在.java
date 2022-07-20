package testproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 检查整数及其两倍数是否存在 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]/2)&&arr[i]%2==0){
                return true;
            }
            if(map.containsKey(arr[i]*2)){
                return true;
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return false;
    }
}
