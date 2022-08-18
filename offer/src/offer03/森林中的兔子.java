package offer03;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 森林中的兔子 {
    public int numRabbits(int[] answers){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<answers.length;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int sum=0;
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
             int key=entry.getKey(),value=entry.getValue();
             sum+=Math.ceil(value*1.0/(key+1))*(key+1);
        }
        return sum;
    }
    @Test
    public void test(){
        int[]ans=new int[]{10,10,10};
        System.out.println(numRabbits(ans));
    }
}
