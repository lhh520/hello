package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 马戏团人塔 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][]env=new int[height.length][2];
        for(int i=0;i<env.length;i++){
            env[i][0]=height[i];
            env[i][1]=weight[i];
        }
        Arrays.sort(env, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //第一个从大到小
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        List<Integer> f = new ArrayList<Integer>();
        f.add(env[0][1]);
        for (int i = 1; i < env.length; ++i) {
            int num = env[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();

    }
    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
