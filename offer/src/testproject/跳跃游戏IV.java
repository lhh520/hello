package testproject;

import org.junit.Test;

import java.util.*;

public class 跳跃游戏IV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer>list=map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        Set<Integer>visitedIndex=new HashSet<>();
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        visitedIndex.add(0);
        while (!queue.isEmpty()){
            int[]idxStep=queue.poll();
            int idx=idxStep[0],step=idxStep[1];
            if(idx==arr.length-1){
                return step;
            }
            int v=arr[idx];
            step++;
            if(map.containsKey(v)){
                for(int i:map.get(v)){
                    if(visitedIndex.add(i)){
                        queue.add(new int[]{i,step});
                    }
                }
                map.remove(v);
            }
            //
            if(idx+1<arr.length&&visitedIndex.add(idx+1)){
                queue.offer(new int[]{idx+1,step});
            }
            if(idx-1>=0&&visitedIndex.add(idx-1)){
                queue.offer(new int[]{idx-1,step});
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[]arr=new int[]{100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }
}
