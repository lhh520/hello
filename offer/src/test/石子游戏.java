package test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 石子游戏 {
    public boolean stoneGame(int[] piles) {
        Deque<Integer>deque=new LinkedList();
        for(int i=0;i<piles.length;i++){
            deque.push(piles[i]);
        }
        int num1=0;
        int num2=0;
        int i=0;
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
        return num1>num2?true:false;
    }
    @Test
    public void test(){
        int[]piles =new int[]{5,3,4,5};
        System.out.println(stoneGame(piles));
    }
}
