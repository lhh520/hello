package face;

import org.junit.Test;

import java.util.*;
import java.util.Comparator;

public class 统计包含每个点的矩形数目 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = rectangles.length;
        //哈希表key为高度，List为宽度的集合。
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int l = rectangles[i][0];
            int h = rectangles[i][1];
            List<Integer> list = map.getOrDefault(h, new ArrayList<>());
            list.add(l);
            map.put(h, list);
        }
        //由于需要对宽度的列表使用二分法，所以需要排序。
        for (int key : map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++){
            int[] p = points[i];
            int x = p[0];
            int y = p[1];
            int count = 0;
            //本题重点，枚举可能的高度，并找到当前高度下，合法的矩形数量。
            for (int h = 100; h >= 1; h--){
                //枚举高度已经比point的高度还小了，不可能再找到合法矩形了。
                if (h < y) break;
                //不存在以当前h为高度的矩形，跳过。
                if (!map.containsKey(h)) continue;
                //二分搜索，并累加答案
                count += binarySearch(map.get(h), x);
            }
            ans[i] = count;
        }
        return ans;

    }

    public int binarySearch(List<Integer> nums, int k){
        int n=nums.size();
        int left=0;
        int right=n-1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= k){
                right = mid;
            }
            else{
                left = mid  + 1;
            }
        }
        return nums.get(right)>=k?n-right:0;
    }
    //

    @Test
    public void test(){
        //rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
        int[][]rectangles=new int[][]{{1,2},{2,3},{2,5}};
        int[][]points=new int[][]{{2,1},{1,4}};
        int[]ret=countRectangles(rectangles,points);
        System.out.println(Arrays.toString(ret));
    }
}
