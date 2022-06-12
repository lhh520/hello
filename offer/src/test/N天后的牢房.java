package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N天后的牢房 {
    Map<String,Integer>map=new HashMap<>();
    public int[] prisonAfterNDays(int[] cells, int n) {
        while (n>0){
            int[]copy=new int[8];
            map.put(Arrays.toString(cells),n);
            n--;
            for(int i=1;i<7;i++){
                copy[i]=cells[i-1]==cells[i+1]?1:0;
            }
            cells=copy;
            if(map.containsKey(Arrays.toString(cells))){
                n=map.get(Arrays.toString(cells));
            }
        }
        return cells;
    }
    @Test
    public void test(){
        int[] cells=new int[]{0,1,0,1,1,0,0,1};
        int n=7;
        int[]ans=prisonAfterNDays(cells,7);
        System.out.println(Arrays.toString(ans));
    }
}
