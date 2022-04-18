package test;

public class test135 {
    public int candy(int[] ratings) {
        int[]candys=new int[ratings.length];
        candys[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                candys[i]=candys[i-1]+1;
            else
                candys[i]=1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candys[i]=Math.max(candys[i],candys[i+1]+1);
        }
        int sum=0;
        for(int i=0;i<candys.length;i++){
            sum=sum+candys[i];
        }
        return sum;
    }
}
