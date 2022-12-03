package dp;
import java.util.*;
import java.util.ArrayList;
import java.util.*;

public class LRU {

    private static List list;//创建一个长度为3的集合,其功能相当于有三个物理块
    private static int len;
    private static Integer count = 0;//用于统计没有缺页的数量

    private static List put(Integer data){
        //判断物理块里面的数据是否大于三个
        if (list.size() < len){//物理块长度小于三时，直接向里面添加数据
            //判断当前数据是否在物理块中已经存在
            for(int i = 0;i < list.size();i++) {
                if (list.get(i) == data) { //存在的情况，当前数据存在物理块中，表示没有中断
                    System.out.print("这个没有中断----");
                    count++;//计数加1
                    return list;//直接返回原来的物理块，不做任何处理
                }
            }
            list.add(data);//不在在情况下，将形式参数的值添加到物理块集合中
        }else {//当物理块大于3时
            for(int i = 0;i < list.size();i++) {
                if (list.get(i) == data) {
                    count++;
                    return list;
                }
            }
            list.remove(0);
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {
        //创建一个数组保存访问页顺序
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strs=str.split(",");


        len=Integer.parseInt(strs[0]);
        Integer[] data = new Integer[strs.length-1];
        for(int i=1;i<strs.length;i++){
            data[i-1]=Integer.parseInt(strs[i]);
        }
        list=new ArrayList(len);
        //上课照片例题数据集

        //循环，一个一个的放入物理块中
        for(int i = 0;i < data.length;i++) {
            put(data[i]);
        }
        System.out.println(list);
    }
}



