package testproject;

import org.junit.Test;

import java.util.*;

public class 将整数按权重排序 {
    public int getKth(int lo, int hi, int k) {
        List<Integer>list=new ArrayList<>();
        for(int i=lo;i<=hi;i++){
            list.add(i);
        }
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int k1=getK(o1);
                int k2=getK(o2);
                return k1==k2?o1-o2:k1-k2;
            }
        });
        System.out.println(list.toString());
        return list.get(k-1);
    }
    public int getK(int num){
        int count=0;
        while (num!=1){
            if(num%2==0){
                num=num/2;
            }else{
                num=3*num+1;
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
    //
    Map<Integer, Integer> f = new HashMap<Integer, Integer>();
    public int get(int x) {
       if(!f.containsKey(x)){
           if(x==1){
               f.put(x,0);
           }else if(x%2!=0){
               f.put(x,get(x*3+1)+1);
           }else {
               f.put(x,get(x/2)+1);
           }
       }
       return f.get(x);
    }
    @Test
    public void test(){
        int lo = 12, hi = 15, k = 2;
        System.out.println(getKth(lo,hi,k));
    }
}
