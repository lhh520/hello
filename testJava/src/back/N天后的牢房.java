package back;
import java.util.*;
public class N天后的牢房 {
    Map<String,Integer>map=new HashMap<>();
    public int[] prisonAfterNDays(int[] cells, int n) {
        while (n>0){
            int[]copy=new int[8];
            map.put(Arrays.toString(copy),n);
            n--;
            for(int i=1;i<7;i++){
                copy[i]=copy[i-1]==cells[i+1]?1:0;
            }
            cells=copy;
            if(map.containsKey(Arrays.toString(cells))){
                n=map.get(Arrays.toString(cells));
            }
        }
        return cells;
    }
}
