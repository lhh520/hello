package testproject;
import org.junit.Test;

import java.util.Arrays;

public class 高度检查器 {
    public int heightChecker(int[] heights) {
        int[]old=heights.clone();
        Arrays.sort(heights);
        int ans=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=old[i]){
                ans++;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]heights =new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}
