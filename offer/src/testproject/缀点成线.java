package testproject;

import org.junit.Test;

public class 缀点成线 {
    public boolean checkStraightLine(int[][] coordinates) {
        int[]pre=coordinates[0];
        double pr=0.0;
        int count=0;
        for(int i=0;i<coordinates.length;i++){
            if(coordinates[i][0]==0){
                count++;
            }
        }
        if(count==coordinates.length){
            return true;
        }
        for(int i=1;i<coordinates.length;i++){
            int[] cur=coordinates[i];
            int dx=cur[0]-pre[0];
            int dy=cur[1]-pre[1];

            if(i==1){
                pr=1.0*dy/dx;
            }else {
                double bb=1.0*dy/dx;
                if(Math.abs(bb-pr)>0.001){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[][]coordinates =new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(checkStraightLine(coordinates));
    }
}
