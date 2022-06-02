package test;

import org.junit.Test;

import java.util.Arrays;

public class 宝石补给 {
    public int giveGem(int[] gem, int[][] operations) {
        for(int[]ope:operations){
            int x=ope[0];
            int y=ope[1];
            int temp=gem[x]/2;
            gem[x]=gem[x]-temp;
            gem[y]=gem[y]+temp;
            //System.out.println(Arrays.toString(gem));
        }
        Arrays.sort(gem);
        int n=gem.length;
        return gem[n-1]-gem[0];
    }
    @Test
    public void test(){
        int[]gem=new int[]{3,1,2};
        int[][]operations =new int[][]{{0,2},{2,1},{2,0}};
        System.out.println(giveGem(gem,operations));
    }
}
