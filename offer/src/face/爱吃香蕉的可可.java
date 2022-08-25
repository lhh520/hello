package face;

public class 爱吃香蕉的可可 {
    public int minEatingSpeed(int[] piles, int h){
        int max=0;
        for(int k=0;k<piles.length;k++){
            max=Math.max(max,piles[k]);
        }
        int low=0,high=piles.length-1;
        int ans=0;
        while (low<=high){
            int speed=low+(high-low)/2;
            long time=getTime(piles,speed);
            if(time<=h){
                ans=speed;
                high=speed-1;
            }else {
                low=speed+1;
            }
        }
        return ans;
    }

    public long getTime(int[] piles, int speed){
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
