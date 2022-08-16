package dp;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 买票需要的时间 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Deque<int[]>deque=new ArrayDeque<>();
        for(int i=0;i<tickets.length;i++){
            deque.add(new int[]{i,tickets[i]});
        }
        int ret=0;
        while (true){
            ret++;
            int[]temp=deque.pollFirst();
            temp[1]--;
            if(temp[0]==k&&temp[1]==0){
                return ret;
            }
            if(temp[1]>0){
                deque.addLast(temp);
            }
        }
    }
    @Test
    public void test(){
        int[]tickets =new int[]{2,3,2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets,k));
    }
}
