package testproject;

public class 狒狒吃香蕉 {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int k=0;k<piles.length;k++){
            max=Math.max(max,piles[k]);
        }
        int low=1,high=max;
        int ans=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            long t=getTime(piles,mid);
            if(t<=h){
                 ans=mid;
                 high=mid-1;
            }else {
                 low=mid+1;
            }
        }

        return ans;
    }
    public long getTime(int[] piles,int speed){
        long time=0;
        for(int j=0;j<piles.length;j++){
            time+=piles[j]/speed;
            if(piles[j]%speed!=0){
                time++;
            }
        }
        return time;
    }
}
