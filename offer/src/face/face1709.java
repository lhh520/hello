package face;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class face1709 {
    public int getKthMagicNumber(int k) {
        //最小堆
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int[] fator=new int[]{3,5,7};
        int sum=1;
        priorityQueue.add(sum);
        for(int i=0;i<k;i++)
        {
            sum= priorityQueue.peek();
            priorityQueue.add(sum*3);
            priorityQueue.add(sum*5);
            priorityQueue.add(sum*7);
        }
        return priorityQueue.peek();
    }
    public int getKthMagicNumber1(int k) {
        // 最小堆处理写入数值  试了Integer不够
        PriorityQueue<Long> PriorityQueue = new PriorityQueue<>();
        // HashSet 保存k个位数值
        Set<Long> list = new HashSet<>();
        PriorityQueue.add(1L);
        while ( true ) {
            // 获取并删除队首元素
            Long val = PriorityQueue.poll();
            // 该元素是否已在HashSet中，在将不操作，否则插入
            if ( !list.contains(val) ) {
                list.add(val);
                PriorityQueue.add( val * 3 );
                PriorityQueue.add( val * 5 );
                PriorityQueue.add( val * 7 );
            }
            // 返回第k个位数值
            if ( list.size() == k ) {
                return val.intValue();
            }
        }
    }



}
