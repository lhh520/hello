package testproject;

import org.junit.Test;

import java.util.*;

public class 找出3位偶数 {
    public int[] findEvenNumbers(int[] digits) {
        int len=digits.length;
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                for(int k=0;k<len;k++){
                    if(i==j||j==k||k==i){//表示有重复
                        continue;
                    }

                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if(num>100&&set.add(num)&&num%2==0)
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        int[]ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
    @Test
    public void test(){
        int[]d=new int[]{2,1,3,0};
        int[]ret=findEvenNumbers(d);
        System.out.println(Arrays.toString(ret));
    }
}
