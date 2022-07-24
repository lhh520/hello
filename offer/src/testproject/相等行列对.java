package testproject;

import org.junit.Test;

import java.util.*;

public class 相等行列对 {
    public int equalPairs(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Map<List<Integer>,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<m;i++){
            List<Integer>list1=new ArrayList<>();
            for(int j=0;j<n;j++){
                list1.add(grid[i][j]);
            }
            //set1.add(new ArrayList<>(list1));
            map.put(new ArrayList<>(list1),map.getOrDefault(new ArrayList<>(list1),0)+1);
        }
        System.out.println(1);
        //
        for(int j=0;j<n;j++){
            List<Integer>list1=new ArrayList<>();
            for(int i=0;i<n;i++){
                list1.add(grid[i][j]);
            }
            System.out.println(list1.toString());
            int num=map.getOrDefault(new ArrayList<>(list1),0);
            count+=1*num;
        }
        return count;
    }
    @Test
    public void test(){
        //[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
        int[][]grid=new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
    }
}
