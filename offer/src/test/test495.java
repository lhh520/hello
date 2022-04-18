package test;

public class test495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    int ans=0;
    int ex=0;
    for(int i=0;i<timeSeries.length;i++)
    {
        if(timeSeries[i]>=ex)
            ans=ans+duration;
        else
            ans=ans+timeSeries[i]+duration-ex;
        ex=timeSeries[i]+duration;
    }
    return ans;
    }
}
