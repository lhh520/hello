package dp;
import java.util.*;
public class cdcd {
    public ArrayList<Integer> Calc (int S, int[] prices) {
        // write code here
        int count2=0;
        for(int i=0;i<prices.length;i++){
           count2+=prices[i]/S;
        }
        int[]nums=new int[prices.length];



        ArrayList<Integer>list=new ArrayList<>();
        list.add(count2);
        list.add(count2);
        return list;
    }
}
