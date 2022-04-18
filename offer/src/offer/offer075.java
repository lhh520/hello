package offer;

import org.junit.Test;

import java.util.*;

public class offer075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr2.length;i++)
        {
            map.put(arr2[i],i);
        }
        System.out.println(1);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr1.length;i++)
        {
            list.add(arr1[i]);
        }

        //Collections.sort(list,Com);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int key1,key2;
                if(!map.containsKey(o1))
                key1=Integer.MAX_VALUE;
                else
                key1=map.get(o1);
                if(!map.containsKey(o2))
                    key2=Integer.MAX_VALUE;
                else
                    key2=map.get(o2);
                if(key1>=key2)
                    return 1;
                else
                    return -1;
            }
        });
        //System.out.println(list.toString());
        int flag=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=list.get(i);
            if(!map.containsKey(arr1[i]))
                flag=Math.min(i,flag);
        }
        //System.out.println(flag);
        if(flag<arr1.length)
        Arrays.sort(arr1,flag,arr1.length);
        return arr1;
    }
    @Test
    public void test()
    {   //[28,6,22,8,44,17]
//[22,28,8,6]
        //[943,790,427,722,860,550,225,846,715,320]
        //[943,715,427,790,860,722,225,320,846,550]
        int[]arr1 = new int[]{943,790,427,722,860,550,225,846,715,320};
        int[]arr2 = new int[]{943,715,427,790,860,722,225,320,846,550};
        int[] ans=relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }
}
