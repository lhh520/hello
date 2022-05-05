package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 找出游戏的获胜者 {
    int yuesefu(int n,int m){
        if(n == 1){
            return 0; //这里返回下标,从0开始，只有一个元素就是剩余的元素0
        }
        else{
            return (yuesefu(n-1,m) + m) % n; //我们传入的n是总共多少个数
        }
    }


    public int findTheWinner(int n, int k) {
        int yy=yuesefu(n,k);
        System.out.println(yy+1);
        int res=0;
        for(int i=2;i<=n;i++){
            res=(res+k)%i;
        }
        System.out.println(res+1);

        Queue<Integer>queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while (queue.size()>1){
            for(int i=1;i<k;i++){
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
    @Test
    public void test(){
        int y=findTheWinner(5,2);
        System.out.println(y);
    }
}
