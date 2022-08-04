package testproject;

import java.util.HashMap;
import java.util.Map;

public class 可互换矩形的组数 {
    public long interchangeableRectangles(int[][] rectangles) {
        final long BASE = (long)1e8;
        Map<Long,Long>map=new HashMap<>();
        for(int[]p:rectangles){
            int a=p[0],b=p[1];
            int div=gcd(a,b);
            long fr=(a/div)*BASE+b/div;
            map.put(fr,map.getOrDefault(fr,0L)+1);
        }
        long sum=0L;
        for(long x:map.values()){
            sum+=x*(x-1)/2;
        }
        return sum;
    }
    public int gcd(int a,int b){
        if(a<b) return gcd(b,a);//保证前一个数比较大
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}
