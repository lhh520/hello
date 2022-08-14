package stack;
import java.util.*;
public class 最多能完成排序的块II {
    public int maxChunksToSorted(int[] bills) {
        Map<Integer,Integer>cnt=new HashMap<>();
        int res=0;
        int[]sortArr=new int[bills.length];
        System.arraycopy(bills,0,sortArr,0,bills.length);
        Arrays.sort(sortArr);
        for(int i=0;i<sortArr.length;i++){
            int x=bills[i],y=sortArr[i];
            cnt.put(x,cnt.getOrDefault(x,0)+1);
            if(cnt.get(x)==0){
                cnt.remove(x);
            }
            cnt.put(y,cnt.getOrDefault(y,0)-1);
            if(cnt.get(y)==0){
                cnt.remove(y);
            }
            if(cnt.isEmpty()){
                res++;
            }
        }
        return res;
    }
}
