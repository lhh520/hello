package test;

import org.junit.Test;

import java.util.*;

public class 钥匙和房间 {
    boolean[]flag;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //广度优先遍历
        int len=rooms.size();
        flag=new boolean[len];
        Queue<Integer>queue=new LinkedList<>();
        for(int i:rooms.get(0)){
            queue.add(i);
        }
        flag[0]=true;
        while (!queue.isEmpty()){//如果不为空
            int x=queue.poll();
            flag[x]=true;
            for(int y:rooms.get(x)){//表示所有可以到达的房间
                if(flag[y]){
                    continue;
                }
                queue.add(y);
            }
        }
        for(int i=0;i<len;i++){
            if(!flag[i])
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        List<List<Integer>> rooms=new ArrayList<>();
        for(int i=1;i<=3;i++){
            List<Integer>list=new ArrayList<>();
            list.add(i);
            rooms.add(new ArrayList<>(list));
        }
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));
    }
}
