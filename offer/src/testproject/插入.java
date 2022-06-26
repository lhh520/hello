package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 插入 {
    public int insertBits(int N, int M, int i, int j) {
        List<Integer>list1=getBits(N);
        Collections.reverse(list1);
        List<Integer>list2=getBits(M);
        while (list2.size()<j-i){
            list2.add(0);
        }
        Collections.reverse(list2);
        System.out.println(list2.toString());
        int k=list1.size()-j-1;
        for(int ii=0;ii<list2.size();ii++){
            if(k>=0&&k<list1.size()){
               list1.set(k++,list2.get(ii));}
            else {
                list1.add(list2.get(ii));
            }
        }
        System.out.println(list1.toString());
        Collections.reverse(list1);
        int decimal=0,p=0;
        for(int ii=0;ii<list1.size();ii++){
            decimal+=(list1.get(ii)*Math.pow(2,p));
            p++;
        }
        return decimal;
        //
    }
    public List<Integer> getBits(int n){
        List<Integer>list=new ArrayList<>();
        while (n!=0){
            int temp=n%2;
            list.add(temp);
            n=n/2;
        }

        return list;
    }
    public int insertBits1(int N, int M, int i, int j) {
        //left in (,j+1];middle in [i,j];right in [i-1,0];
        System.out.println(Integer.toBinaryString(N));
        int left = N>>j>>1; //把最左边的部分调整好了，即抛弃了替换部分和低位部分
        System.out.println(Integer.toBinaryString(left));
        left = left<<j<<1;  //因此最后要进行或运算，所以把他再移到原来的高位上。
        int middle = M<<i;  //替换N的j<-----i位，那么只需要将M左移i位即可
        System.out.println(Integer.toBinaryString(middle));
        int right = N&((1<<i)-1);//只需要N的低位，将高位置零,(1<<2)-1 = (11)2
        System.out.println(Integer.toBinaryString(right));
        return left | middle | right;

    }
    @Test
    public void test(){
        int N = 1024, M = 19,i = 2, j = 6;
        System.out.println(insertBits1(N,M,i,j));
    }
}
