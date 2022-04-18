package test;

import java.util.HashMap;

public class test1640 {
    public boolean canFormArray(int[] arr, int[][] pieces)
    {
        HashMap<Integer,int[]>map=new HashMap<>();
        //把数组的第一个元素放入map
        for(int[] piece:pieces)
            map.put(piece[0],piece);
        //遍历数组arr,找到map中对应的数组
        for (int i = 0; i <arr.length; i++)
        {
            int curVal=arr[i];
        if(map.containsKey(curVal))
        {
            //找到以后遍历map的数组，如果挨个和arr[i]对上，就继续找，直到遍历结束
            int[] piece=map.get(curVal);
            for(int x:piece)
            {
                if(arr[i]==x)
                    i++;
                else
                    return false;
            }
        }
        else
            return false;
        }
        return true;
    }
}
