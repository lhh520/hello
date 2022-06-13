package testproject;

import org.junit.Test;

public class 等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
        int[]nums=new int[100];
        for(int i=0;i<dominoes.length;i++){
            int val=dominoes[i][0]>dominoes[i][1]?dominoes[i][1]*10+dominoes[i][0]:dominoes[i][0]*10+dominoes[i][1];
            nums[val]++;
        }
        for(int i=0;i<100;i++){
            if(nums[i]>=2){
                count+=(nums[i]-1)*nums[i]/2;
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[][]domions=new int[][]{{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(domions));
    }
}
