package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OPPO01 {
    public int maxDigit (int[] digits) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<digits.length;i++){
            list.add(digits[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                String s1= String.valueOf(Integer.parseInt(String.valueOf(o1)));
                String s2= String.valueOf(Integer.parseInt(String.valueOf(o2)));
                return (s2+s1).compareTo(s1+s2);
            }
        });
        int num=0;
        for(int i=0;i<list.size();i++){
            num=num*10+list.get(i);
        }
        return num;
    }
    @Test
    public void test(){
        int[] digits=new int[]{3,4};
        int m=maxDigit(digits);
        System.out.println(m);
    }
}
