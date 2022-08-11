package stack;
import java.util.*;
public class 石子游戏 {
    public boolean stoneGame(int[] piles){
        Deque<Integer>deque=new LinkedList<>();
        for(int i=0;i<piles.length;i++){
            deque.add(piles[i]);
        }
        int num1=0,num2=0,i=0;
        while (!deque.isEmpty()){
            if(i%2==0){
                if(deque.getFirst()>deque.getLast()){
                    num1+=deque.getFirst();
                    deque.pollFirst();
                }else {
                    num1+=deque.getLast();
                    deque.pollLast();
                }
            }else {
                if(deque.getFirst()>deque.getLast()){
                    num2+=deque.getFirst();
                    deque.pollFirst();
                }else {
                    num2+=deque.getLast();
                    deque.pollLast();
                }
            }
        }
        //
        return num1>num2?true:false;
    }
}
