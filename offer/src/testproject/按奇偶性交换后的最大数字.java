package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 按奇偶性交换后的最大数字 {
    public int largestInteger(int num) {
        String s=Integer.toString(num);
        char[]cc=s.toCharArray();
        List<Character>list=new ArrayList<>();
        List<Character>list1=new ArrayList<>();
        for(char c:cc){
            if((c-'0')%2==0){
                list.add(c);
            }else {
                list1.add(c);
            }
        }
        //完成 开始排序
        Collections.sort(list);
        Collections.sort(list1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cc.length;i++){
            if((cc[i]-'0')%2==0){
                sb.append(list.get(list.size()-1));
                list.remove(list.size()-1);
            }else {
                sb.append(list1.get(list1.size()-1));
                list1.remove(list1.size()-1);
            }
        }
        return Integer.parseInt(sb.toString());
    }
    @Test
    public void test(){
        int num=1234;
        System.out.println(largestInteger(num));
    }
}
