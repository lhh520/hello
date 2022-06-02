package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 太平洋大西洋水流问题 {
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][]pac;
        int[][]alt;
        pac=new int[m][n];
        alt=new int[m][n];
        //pac
        for(int i=0;i<n;i++){
            backtrace(heights,0,i,pac);
        }
        for(int i=0;i<m;i++){
            backtrace(heights,i,0,pac);
        }
        //atl
        for(int i=0;i<n;i++){
            backtrace(heights,m-1,i,alt);
        }
        for(int i=0;i<m;i++){
            backtrace(heights,i,n-1,alt);
        }
        List<List<Integer>>lists=new ArrayList<>();
        //开始直接遍历
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pac[i][j]!=0&&alt[i][j]!=0){
                    List<Integer>list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(new ArrayList<>(list));
                }
            }
        }
        return lists;
    }
    public void backtrace(int[][] heights,int i,int j,int[][]ocan){
        //退出循环
        if(ocan[i][j]!=0){
            return;
        }
        //开始向四周进行遍历
        ocan[i][j]=1;
        for(int k=0;k<4;k++){
            int dx=i+dirs[k][0];
            int dy=j+dirs[k][1];
            if(dx>=0&&dx<heights.length&&dy>=0&&dy<heights[0].length&&heights[dx][dy]>=heights[i][j]){
                backtrace(heights,dx,dy,ocan);
            }
        }
    }
    @Test
    public void test(){
        int[][]heights =new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>>lists=pacificAtlantic(heights);
        System.out.println(lists.toString());
    }
}
