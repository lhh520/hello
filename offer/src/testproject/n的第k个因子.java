package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class n的第k个因子 {
    public int kthFactor(int n, int k) {
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(n%i==0){
                list.add(i);
            }
            if(list.size()==k){
                break;
            }
        }
        if(list.size()<k){
            return -1;
        }
        return list.get(list.size()-1);
    }
    @Test
    public void test(){
        System.out.println(kthFactor(12,3));
    }
}
