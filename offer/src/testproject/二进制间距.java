package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二进制间距 {
    public int binaryGap(int n) {
        List<Integer> list=new ArrayList<>();
        while (n>0){
            int temp=n%2;
            list.add(temp);
            n=n/2;
        }
        Collections.reverse(list);
        int[]count=new int[list.size()];
        List<Integer>list2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)==1){
                list2.add(i);
            }
        }
        if(list2.size()<=1)
            return 0;
        int max=0;
        for (int j=1;j<list2.size();j++){
            max=Math.max(max,list2.get(j)-list2.get(j-1));
        }
        //System.out.println(list);
        return max;
    }
    @Test
    public void test(){
        System.out.println(binaryGap(8));
    }
}
