package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 寻找右区间 {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[][]startIndex=new int[n][2];
        for(int i=0;i<n;i++){
            startIndex[i][0]=intervals[i][0];//起始的位置
            startIndex[i][1]=i;
        }
        //进行升序排列
        Arrays.sort(startIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<startIndex.length;i++){
            System.out.println(Arrays.toString(startIndex[i]));
        }
        //排序后进行二分查找
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            int target=-1;
            while (left<=right){
                int mid=left+(right-left)/2;
                if(intervals[i][1]<=startIndex[mid][0]){
                    target=startIndex[mid][1];
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            ans[i]=target;
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]intervals=new int[][]{{3,4},{2,3},{1,2}};
        int[]ans=findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
}
