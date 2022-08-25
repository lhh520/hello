package face;
import org.junit.Test;

import java.util.*;
public class 找到K个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a=Math.abs(o1-x);
                int b=Math.abs(o2-x);
                if(a==b){
                    return o1-o2;
                }else {
                    return a-b;
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }
        Collections.sort(list);
        return list;
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,2,3,4,5};
        List<Integer>list=findClosestElements(arr,4,3);
        System.out.println(list);
    }
}
