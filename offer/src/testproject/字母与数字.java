package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length, count = 0, max = 0, from = 0, to = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            char c = array[i].charAt(0);
            count += isNum(c) ? -1 : 1;//前缀和，计数
            if (map.containsKey(count)) {//表明之前已经存在相同的情况，两个标记之间之间的所有的和一定为0
                int num = map.get(count);//之前为count的坐标
                if (i - num > max) {//表明两者之间的距离已经大于
                    max = i - num;
                    from = num;
                    to = i;
                }
            } else {
                map.put(count, i);
            }
        }

        return Arrays.copyOfRange(array, from + 1, to + 1);
    }
    private boolean isNum(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    //
    public String[] findLongestSubarray1(String[] array){
        int max=0;//最大值
        int count=0;//表明当前的值为0
        int from=0,to=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<array.length;i++){
            char c=array[i].charAt(0);
            int temp=isNum(c)?-1:1;
            count=count+temp;
            if(map.containsKey(count)){
                int pre=map.get(count);//之前的数字
                if(i-pre>max){
                    max=i-pre;
                    from=pre;
                    to=i;
                }
            }else {
                map.put(count,i);//记录当前值，以及所在的坐标
            }

        }
        return Arrays.copyOfRange(array,from+1,to+1);
    }

    @Test
    public void test(){
        //["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
        String[] nn=new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] n1=findLongestSubarray1(nn);
        System.out.println(Arrays.toString(n1));

    }

}
