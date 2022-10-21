import org.junit.Test;

import java.util.*;
public class tests {
    public ArrayList<Integer> FindHouse (int[] house) {
        // write code here
        int[]nums=new int[house.length];
//        for(int i=0;i<house.length;i++){
//            nums[i]=0;
//        }
        for(int i=0;i<house.length;i++){
            if(house[i]==-1){
                continue;
            }else {
                int cur=house[i];
                if(i-cur>0){
                    nums[i-cur]++;
                }
                if(i+cur<nums.length){
                    nums[i+cur]++;
                }
            }

        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                list.add(i);
            }
        }
        Collections.sort(list);
        if(list.get(0)==0){
            for(int i=0;i<nums.length;i++){
                list.add(i);
            }
        }
        System.out.println(Arrays.toString(nums));
        return list;
    }
    @Test
    public void test(){
        //[-1,-1,-1,-1,-1,-1]
        int[]nums=new int[]{-1,-1,-1,-1,-1,-1};
        System.out.println(FindHouse(nums));
    }
}
