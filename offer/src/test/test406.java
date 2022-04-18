package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test406 {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        //基本排序,第一个降序，第二个升序

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0]!=person2[0]){
                    return person2[0]-person1[0];
                }else
                    return person1[1]-person2[1];
            }
        });
        List<int[]>list=new ArrayList<>();
        //基本排序之后可以插入排序
        for(int[]person:people){
            if(list.size()<=person[1])//表示当前的数量小于应有的数字,小于直接后方插入
                list.add(person);
            else
                list.add(person[1],person);
        }
        int[][]ans=new int[n][];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]people=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][]ans=reconstructQueue(people);

        for(int i=0;i<people.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
