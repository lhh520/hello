package LCP;

import java.util.*;

public class LCS02 {
    public static int halfQuestions(int[] questions) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<questions.length;i++)
        {
            map.put(questions[i],map.getOrDefault(questions[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            int val=entry.getValue();
            list.add(val);
        }
        Collections.sort(list);
        System.out.println(list.toString());
        int ans=0;
        int len=0;
        int kk=questions.length/2;
        System.out.println(kk);
        for(int i=list.size()-1;i>=0;i--)
        {
            ans=ans+list.get(i);
            System.out.println(ans);
            len++;
            if(ans>=kk)
            return len;
        }
        return len;
    }

    public static void main(String[] args) {
        //questions = [2,1,6,2]
        int[]questions=new int[]{1000,1000};
        System.out.println(halfQuestions(questions));
    }
}
