package testproject;

import java.util.Arrays;

public class 设置交集大小至少为2 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int pre1=intervals[0][1]-1;
        int pre2=intervals[0][1];
        int ans=2;
        for(int i=1;i<intervals.length;i++){
            if(pre1>=intervals[i][0]&&pre2<=intervals[i][1]){//两个数都在范围之内
                continue;
            }else if(pre2<intervals[i][0]){//两个数都不在范围之内
                ans+=2;
                pre1=intervals[i][1]-1;//加了2 之后 重新更新值
                pre2=intervals[i][1];
            }
            else if(pre1<intervals[i][0]){
                ans++;
                if(pre2==intervals[i][1]){
                    pre1=pre2-1;
                }else {
                    pre1=pre2;
                    pre2=intervals[i][1];
                }
            }
        }
        return ans;
    }
}
