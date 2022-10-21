package hot100;

import org.junit.Test;

public class testdcdc {
    public int maximumBonuses (int[] bonuses, long k) {
        // write code here
        int max=0;
        int min=0;
        for(int i=0;i<bonuses.length;i++){
            max=Math.max(max,bonuses[i]);
        }
        int left=1,right=max;
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int i=0;i<bonuses.length;i++){
                //当前的数值wei mid
                count+=(bonuses[i]/mid);
            }
            if(count<k){
                right=mid-1;
            }else {
                ans=mid;
                left=mid+1;

            }
        }
        return ans;
    }
    @Test
    public void test(){
        //[6, 9, 7],3
        int[]b=new int[]{6,9,7};
        System.out.println(maximumBonuses(b,3));

    }
}
