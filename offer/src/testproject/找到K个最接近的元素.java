package testproject;

import org.junit.Test;

import java.util.*;

public class 找到K个最接近的元素 {
    int centre;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        centre=x;
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int mm=Math.abs(o1-centre)-Math.abs(o2-centre);
                if(mm==0){
                    return o1-o2;
                }else {
                    return Math.abs(o1-centre)-Math.abs(o2-centre);
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        List<Integer>list=new ArrayList<>();
        while (k-->0&&!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.sort(list);
        return list;
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,2,3,4,5};
        List<Integer>oo=findClosestElements(arr,4,3);
        System.out.println(oo.toString());
    }
}
