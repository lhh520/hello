package back;

import org.junit.Test;

public class 供暖器 {
    public int findRadius(int[] houses, int[] heaters) {
        int ret=0;
        for(int i=0;i<houses.length;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<heaters.length;j++){
                 min=Math.min(min,Math.abs(heaters[j]-houses[i]));
            }
            ret=Math.max(ret,min);
        }
        return ret;
    }
    @Test
    public void test(){
        int[]houses=new int[]{1,2,3,4};
        int[]heaters=new int[]{1,4};
        System.out.println(findRadius(houses,heaters));
    }
}
