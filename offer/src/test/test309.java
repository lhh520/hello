package test;

import org.junit.Test;

import java.util.ArrayList;

public class test309 {
    public int lastRemaining(int n) {
     int a1=1;
     int k=0,cnt=n,step=1;
     while (cnt>1)
     {
         if(k%2==0)//正向
             a1=a1+step;
         else//反向
             a1=(cnt%2==0)?a1:a1+step;
         k++;
         cnt=cnt>>1;
         step=step<<1;
     }
     return a1;
    }
    public int lastRemaining1(int n) {
        //将1～n存入到temp中
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            temp.add(i);
        }
        int index = 0;
        //模拟删除
        while(true){
            //判断index的奇偶
            if(index % 2 == 0){
                //从左到右进行删除
                for(int i = 0;i < temp.size();i++){
                    //如果当前temp的大小为1 直接返回
                    if(temp.size() == 1){
                        return temp.get(0);
                    }
                    //移除
                    temp.remove(i);//每次的删除之后，所有的数字会向前移动一位，因此，不需要再加1
                }
                System.out.println(temp.toString());
            }

            else{
                //从右到左删除
                for(int i = temp.size()-1;i>=0;i = i-2){
                    if(temp.size() == 1){
                        return temp.get(0);
                    }
                    temp.remove(i);
                }
            }
            index++;
        }
    }
    @Test
    public void test()
    {
        System.out.println(lastRemaining1(9));
    }

}
