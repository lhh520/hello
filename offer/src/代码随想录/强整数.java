package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 强整数 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer>set=new HashSet<>();
        List<Integer>ret=new ArrayList<>();
        if(bound==0){
            return ret;
        }
        if(x==1&&y==1){

            if(bound<2){
               ret.add(1);
               return ret;
            }else {
                ret.add(1);
                ret.add(2);
                return ret;
            }
        }
        if(x==1){
            for(int j=0;Math.pow(y,j)<=bound;j++){
                int cur= (int) (1+Math.pow(y,j));
                if(cur<=bound&&set.add(cur)){
                    ret.add(cur);
                }
            }
            return ret;
        }
        if(y==1){
            for(int j=0;Math.pow(x,j)<=bound;j++){
                int cur= (int) (1+Math.pow(x,j));
                if(cur<=bound&&set.add(cur)){
                    ret.add(cur);
                }
            }
            return ret;
        }

        for(int i=0;Math.pow(x,i)<=bound;i++){
            for(int j=0;Math.pow(y,j)<=bound;j++){
                int cur= (int) (Math.pow(x,i)+Math.pow(y,j));
                if(cur<=bound&&set.add(cur)){
                    ret.add(cur);
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        List<Integer>list=powerfulIntegers(2,1,10);
        System.out.println(list);
    }
}
