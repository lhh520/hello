package testproject;

import org.junit.Test;

import java.util.*;

public class 最小面积矩形 {
    public int minAreaRect(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int n=points.length;
        return (points[n-1][0]-points[0][0])*(points[n-1][1]-points[0][1]);
    }
    public int minAreaRect1(int[][] points){
        Map<Integer, List<Integer>>map=new TreeMap();
        for(int i=0;i< points.length;i++){
            int x = points[i][0], y = points[i][1];
            map.computeIfAbsent(x, z-> new ArrayList()).add(y);
        }
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer>lastx=new HashMap<>();
        for(int x:map.keySet()){
            List<Integer>row=map.get(x);
            Collections.sort(row);
            for(int i=0;i<row.size();i++){
                for(int j=i+1;j<row.size();j++){
                    int y1=row.get(i);
                    int y2=row.get(j);
                    int code=40001*y1+y2;
                    if(lastx.containsKey(code)){
                        ans=Math.min(ans,(x-lastx.get(code))*(y2-y1));
                    }
                    lastx.put(code,x);
                }
            }
        }
        return ans<Integer.MAX_VALUE?ans:0;
    }
    @Test
    public void test(){
        int[][]points=new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(points));
    }
}
