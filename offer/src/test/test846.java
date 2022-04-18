package test;

import java.util.*;

public class test846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len=hand.length;
         if(len%groupSize!=0)
        return false;
        Arrays.sort(hand);
        Map<Integer,Integer> cnt=new HashMap<Integer,Integer>();
        //把当前的数据全部都放入到map中
        for(int x:hand)
        {
           cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        for(int x:hand)
        {   //x是当前的最小值，从当前的最小值进行搜索
            if(!cnt.containsKey(x))
                continue;
            //开始拼凑当前的一组数字
            for (int i = 0; i <groupSize; i++) {
                int num=x+i;
                //如果不能连续，则返回false
                if(!cnt.containsKey(num))
                    return false;
                //使用过的数字，频率减一
                cnt.put(num,cnt.get(num)-1);
                //如果减到了0，则去除当前的值
                if(cnt.get(num)==0)
                    cnt.remove(num);
            }
        }
        return  true;
    }

}
