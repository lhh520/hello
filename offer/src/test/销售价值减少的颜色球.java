package test;

import org.junit.Test;

import java.util.PriorityQueue;

public class 销售价值减少的颜色球 {
    public int maxProfit(int[] inventory, int orders) {
        //优先队列
        int mod= (int) (1e9 + 7);
        PriorityQueue<int[]>pq=new PriorityQueue<>((p1,p2)->p2[1]-p1[1]);
        for(int i=0;i<inventory.length;i++){
            pq.add(new int[]{i,inventory[i]});
        }
        int res=0;
        for(int i=0;i<orders;i++){
            int[]cur=pq.poll();
            //球的价值
            int price=cur[1];
            res=(res+price)%mod;
            if(--cur[1]>0){
                pq.add(cur);
            }
        }
        return res%mod;
    }
    @Test
    public void test(){
        int[]inventory =new int[]{2,5};
        System.out.println(maxProfit(inventory,4));
    }
}
