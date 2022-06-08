package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 有效的回旋镖 {
    public boolean isBoomerang(int[][] points) {
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j){
                    continue;
                }
                if(points[i][0]==points[j][0]||points[i][1]==points[j][1]){
                    return false;
                }
            }
        }
        if((1.0*(points[0][1]-points[0][1])/(points[1][0]-points[1][0]))==(1.0*(points[0][1]-points[0][1])/(points[2][0]-points[2][0])))
        {
            return false;
        }
        return true;
    }
    //
    @Test
    public void test(){
        int[][]points =new int[][]{{1,1},{2,3},{3,2}};
        System.out.println(isBoomerang(points));
    }
}
