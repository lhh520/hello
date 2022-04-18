package Nc;

import org.junit.Test;

import java.util.*;

public class Nc119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<input.length;i++)
        {   if(priorityQueue.size()!=k)
            priorityQueue.add(input[i]);
            else if(priorityQueue.peek()>input[i])
           {
               priorityQueue.poll();
               priorityQueue.offer(input[i]);
           }
        }
        ArrayList<Integer>arrayList=new ArrayList<>();
        Iterator<Integer> it=priorityQueue.iterator();
        while (it.hasNext())
        {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        System.out.println(a);
    }
    @Test
    public void test()
    {
        int[] input=new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer>arrayList=GetLeastNumbers_Solution(input,4);
        System.out.println(arrayList.toString());
        /*Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        System.out.println(a);*/
    }
}
