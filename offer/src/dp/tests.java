package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tests {
    public ArrayList<Integer> FindHouse (int[] house) {
        // write code here
        int[]nums=new int[house.length];
//        for(int i=0;i<house.length;i++){
//            nums[i]=0;
//        }
        boolean flag=false;
//        for(int i=0;i<house.length;i++){
//            if(house[i]==-1){
//                continue;
//            }else {
//                int cur=house[i];
//                if(i-cur>0&&flag==false){
//                    nums[i-cur]++;
//                    flag=true;
//                }
//                if(i+cur<nums.length&&flag==false){
//                    nums[i+cur]++;
//                    flag=false;
//                }
//            }
//
//        }

        int count=0;
        for(int i=0;i<house.length;i++){
            if(house[i]!=-1){
                count=0;
            }

        }
        ArrayList<Integer>list=new ArrayList<>();
        if(count==0){
            for(int i=0;i<nums.length;i++){
                list.add(i);
            }
            return list;
        }
        if(count==1){
            for(int i=0;i<nums.length;i++){
                if(house[i]!=-1){
                    int cur=house[i];
                    if(i-cur>=0){
                        list.add(i-cur);
                    }
                    if(i+cur<nums.length){
                        list.add(i+cur);
                    }
                }
                return list;
            }
        }

        if(count==2){
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

           int max= Arrays.stream(nums).max().getAsInt();
          list.add(max);
          return list;
        }





        Collections.sort(list);

        return list;
    }
    @Test
    public void test(){
        //[-1,-1,-1,-1,-1,-1]
        //[1,-1,-1,2,-1,-1]
        int[]nums=new int[]{1,-1,-1,2,-1,-1};
        System.out.println(FindHouse(nums));
    }
}
