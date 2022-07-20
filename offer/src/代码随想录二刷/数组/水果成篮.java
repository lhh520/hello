package 代码随想录二刷.数组;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 水果成篮 {
    public int totalFruit(int[] fruits){
        //1.连续
        //2.种类不超过2
        Map<Integer,Integer>map=new HashMap<>();
        int len=fruits.length;
        int l=0,r=0;
        int res=0;
        while(r<len){
            map.put(fruits[r],map.getOrDefault(r,0)+1);//想其中扩充
            while (map.size()>2){
                if(map.containsKey(fruits[l])){
                    map.put(fruits[l],map.get(fruits[l])-1);
                    if(map.get(fruits[l])==0){
                        map.remove(fruits[l]);
                    }
                }
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}
