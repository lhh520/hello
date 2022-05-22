package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 跳跃游戏3 {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer>q=new LinkedList<>();
        boolean[]visited=new boolean[n];
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int ix=q.poll();
            int l=ix-arr[ix];
            int r=ix+arr[ix];
            //跳到数据为0的位置
            if(l>=0&&l<n&&arr[l]==0) return true;
            if(r>=0&&r<n&&arr[r]==0) return true;
            if(l>=0&&l<n&&!visited[l]){
                q.add(l);
                visited[l]=true;
            }
            //
            if(r>=0&&r<n&&!visited[r]){
                q.add(r);
                visited[r]=true;
            }

        }
        return false;
    }
    @Test
    public void test(){
        int[]arr =new int[]{4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr,start));
    }
}
