package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 太平洋大西洋水流问题 {
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][]paci=new boolean[m][n];
        boolean[][]Alantic=new boolean[m][n];
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            dfs(0,i,paci,heights);
        }
        for(int i=0;i<m;i++){
            dfs(i,0,paci,heights);
        }
//        System.out.println("before");
//        for(boolean[]yy:paci){
//            System.out.println(Arrays.toString(yy));
//        }
//        System.out.println("after");
        for(int i=0;i<n;i++){
            dfs(m-1,i,Alantic,heights);
        }
        for(int i=0;i<m;i++){
            dfs(i,n-1,Alantic,heights);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(paci[i][j]&&Alantic[i][j]){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,boolean[][] ocan,int[][] heights){
        if(ocan[i][j]){
            return;
        }
        ocan[i][j]=true;
        for(int[]dir:dirs){
            int newRow = i + dir[0], newCol = j + dir[1];
            if(newRow>=0&&newRow< heights.length&&newCol>=0&&newCol<heights[0].length&&heights[newRow][newCol]>=heights[i][j])
            dfs(i+dir[0],j+dir[1],ocan,heights);
        }
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>>ll=pacificAtlantic(nums);
        for(List<Integer>lll:ll){
            System.out.println(lll.toString());
        }
    }
}
