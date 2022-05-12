package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 森林中的兔子 {
    public int numRabbits(int[] answers) {
        Set<Integer>set=new HashSet<>();
        int count=0;
        for(int i=0;i<answers.length;i++){
            if(set.add(answers[i])&&answers[i]!=0){
                count=count+answers[i]+1;
            }
            if(answers[i]==0){
                count=count+1;
            }
        }

        return count;
    }
    public int numRabbits1(int[] answers){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<answers.length;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int n=entry.getKey()+1;
            if(n>entry.getValue()){
                count+=n;
            }else {
                count+=(entry.getValue()/n)*n+n;
            }



        }
        return count;
    }


    @Test
    public void test(){
        int[]answers =new int[]{10,10,10};
        System.out.println(numRabbits1(answers));
    }
}
