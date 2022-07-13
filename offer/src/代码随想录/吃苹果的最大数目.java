package 代码随想录;

import org.junit.Test;

import java.util.PriorityQueue;

public class 吃苹果的最大数目 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int n=apples.length,time=0,ans=0;
        while(time<n||!pq.isEmpty()){//表示还在产生苹果 或者苹果还没有过期完
            if(time<n&&apples[time]>0){
                pq.add(new int[]{time+days[time]-1,apples[time]});//苹果过期日期和苹果个数
            }
            while (!pq.isEmpty()&&pq.peek()[0]<time){//表示顶上的苹果都是过期的 全部出栈
                pq.poll();
            }
            if(!pq.isEmpty()){
                int[]cur=pq.poll();
                if(--cur[1]>0&&cur[0]>time) pq.add(cur);//优先吃的是快要过期的
                ans++;
            }
            time++;
        }
        return ans;
    }
    @Test
    public void test(){
        int[]apples =new int[]{1,2,3,5,2};
        int[]days =new int[]{3,2,1,4,2};
        System.out.println(eatenApples(apples,days));
    }
}
