package testproject;

import java.util.PriorityQueue;

public class 将数组和减半的最少操作次数 {
    public int halveArray(int[] nums) {
        double sum=0;
        PriorityQueue<Double>q=new PriorityQueue<>((a, b)->Double.compare(b,a));
        for(int i=0;i< nums.length;i++){
            q.offer((double)nums[i]);
            sum=sum+(double)nums[i];
        }
        double now=0.0;
        int cnt=0;
        while (now<sum*0.5){
            double head=q.poll();
            double heaf=0.5*head;
            now=now+heaf;
            cnt++;
            q.offer(heaf);
        }
        return cnt;
    }
}
