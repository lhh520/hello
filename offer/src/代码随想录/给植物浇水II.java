package 代码随想录;

import org.junit.Test;

public class 给植物浇水II {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ret=0,i=0,j=plants.length-1;
        int len=plants.length;
        int r1=capacityA,r2=capacityB;
        boolean[]flag=new boolean[len];
        while (i<j){
            flag[i]=true;
            flag[j]=true;
            if(plants[i]>r1){
                ret++;
                r1=capacityA;
            }
            r1-=plants[i];
            //
            if(plants[j]>r2){
                ret++;
                r2=capacityB;
            }
            r2-=plants[j];
            i++;
            j--;
        }
        if(!flag[(i+j)/2]){
            if(Math.max(r1,r2)<plants[(i+j)/2]){
                ret++;
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[]plants =new int[]{2,2,3,3};
        System.out.println(minimumRefill(plants,5,5));
    }
}
