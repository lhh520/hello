package testproject;

import org.junit.Test;

public class 人口最多的年份 {
    public int maximumPopulation(int[][] logs) {
        int offset=1950;
        int[] peopleDealt= new int[102];
        for(int[]log:logs){
            int i=log[0],j=log[1];
            for(int k=i;k<j;k++){
                peopleDealt[k-offset]++;
            }
        }
        int ans=-1,ret=-1;
        for(int i=0;i<peopleDealt.length;i++){
            if(peopleDealt[i]>ans){
                ans=peopleDealt[i];
                ret=offset+i;
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]logs=new int[][]{{1993,1999},{2000,2010}};
        System.out.println(maximumPopulation(logs));
    }
}
