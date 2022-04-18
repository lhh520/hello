package offer;

import java.util.*;

public class offer33 {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list.toString());
        PriorityQueue<Integer> priorityQueue=new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        //Iterable<Integer>iterable= (Iterable<Integer>) priorityQueue.iterator();
        while (!priorityQueue.isEmpty())
        {
            System.out.println(priorityQueue.poll());
        }
    }
}
