package plan92.yyyy;

import java.util.ArrayDeque;
import java.util.Deque;

public class testcdcdc {
    public int timeRequiredToBuyCounpons (int[] coupons, int m) {
         int n=coupons.length;
         int ans=0;
         for(int i=0;i<n;i++){
             if(i<=m){
                 ans+=Math.min(coupons[i],coupons[m])*10;
             }else {
                 ans+=Math.min(coupons[i],coupons[m]-1)*10;
             }
         }
         return ans;
    }
}
