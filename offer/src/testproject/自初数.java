package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 自初数 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i))
                ans.add(i);
        }
        return ans;
    }
    public boolean check(int num){
        int copyOfnum=num;
        while(num>0){
            int temp=num%10;
            if(temp==0||copyOfnum%temp!=0){
                return false;
            }
            num/=10;
        }
        return true;
    }
    @Test
    public void test(){
        List<Integer>list=selfDividingNumbers(1,22);
        System.out.println(list.toString());
    }
}
