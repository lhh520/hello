package 热题100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        //记录从左往右进行的扫描
        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();
        //map1.put(1,0)
        int x1=1;
        for(int i=0;i<a.length;i++){
           map1.put(i,x1);
           x1=x1*a[i];
        }
        x1=1;
        for(int i=a.length-1;i>=0;i--){
            map2.put(i,x1);
            x1=x1*a[i];
        }
        int[]ans=new int[a.length];
        for(int i=0;i<a.length;i++){
            ans[i]=map1.get(i)*map2.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4,5};
        int[]ans=constructArr(nums);
        System.out.println(Arrays.toString(ans));
    }
}
