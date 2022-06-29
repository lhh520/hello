package testproject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        //使用最小序列
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n=matrix.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{matrix[i][0],i,0});//将每一行的第一个数字都放入堆中
        }
        for(int i=0;i<k-1;i++){
            int[]now=pq.poll();
            if(now[2]!=n-1){
                pq.offer(new int[]{matrix[now[1]][now[2]+1],now[1],now[2]+1});
            }
        }
        return pq.poll()[0];
    }
}
