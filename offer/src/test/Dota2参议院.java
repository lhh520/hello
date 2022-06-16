package test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Dota2参议院 {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Deque<Integer>deque1=new LinkedList<Integer>();
        Deque<Integer>deque2=new LinkedList<Integer>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                deque1.add(i);
            }else {
                deque2.add(i);
            }
        }
        while (!deque1.isEmpty()&&!deque2.isEmpty()){
            int count1=deque1.poll();
            int count2=deque2.poll();
            if(count1<count2){
                deque1.add(count1+n);
            }else {
                deque2.add(count2+n);
            }
        }
        if(!deque1.isEmpty()){
            return "Radiant";
        }
        return "Dire";
    }
    @Test
    public void test(){
        String ss="DDRRR";
        System.out.println(predictPartyVictory(ss));
    }
}
