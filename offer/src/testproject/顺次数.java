package testproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 顺次数 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num=i;
            for(int j=i+1;j<=9;j++){
                num=num*10+j;
                if(num>=low&&num>=high){
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
