package 热题100;

import org.junit.Test;

public class 分发糖果 {
    public int candy(int[] ratings) {
        int sz=ratings.length;
        int[]candy=new int[sz];
        candy[0]=1;
        for(int i=1;i<sz;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }else {
                candy[i]=1;
            }
        }
        for(int i=sz-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        int ans=0;
        for(int s:candy){
            ans+=s;
        }
        return ans;
    }
    @Test
    public void test(){
        int[] ratings=new int[]{1,0,2};
        System.out.println(candy(ratings));
    }
}
