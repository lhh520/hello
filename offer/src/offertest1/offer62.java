package offertest1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer62 {
    public int lastRemaining(int n, int m) {

    List<Integer> list=new ArrayList<>();
    for (int i=0;i<n;i++){
        list.add(i);
    }
        System.out.println(list.toString());
    int start=0;
    int index=0;
    while (list.size()>1){
        int len=list.size();
        index = (start + m - 1) % len;
        list.remove(index);
        start=index;
    }
    return list.get(0);
    }
    @Test
    public void test(){
        System.out.println(lastRemaining(5,3));
    }
}
