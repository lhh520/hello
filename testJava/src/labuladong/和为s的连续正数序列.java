package labuladong;
import java.util.*;
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]>vec=new ArrayList<>();
        for(int l=1,r=2;l<r;){
            int sum=(r+l)*(r-l+1)/2;
            if(sum==target){//表示找到了数字，则放到数组中
                int[]res=new int[r-l+1];
                for (int i=l;i<=r;i++){
                    res[i-l]=i;
                }
                vec.add(res);
                l++;
            }else if(sum<target){
                r++;
            }else {
                l++;
            }

        }
        return vec.toArray(new int[vec.size()][]);
    }
}
