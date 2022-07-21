package 代码随想录二刷.哈希表;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 两个数组的交集 {
    public boolean isHappy(int n) {
        Set<Integer>set=new HashSet<>();
        while (true){
            if(n==1){
                return true;
            }
            int sum=0;
            while (n!=0){
                int temp=n%10;
                sum+=temp*temp;
                n=n/10;
            }
            n=sum;
            System.out.println(sum);
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
        }
    }
    @Test
    public void test(){
        System.out.println(isHappy(19));
    }

}
