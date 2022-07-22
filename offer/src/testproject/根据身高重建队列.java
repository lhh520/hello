package testproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        List<int[]>list=new ArrayList<>();
        for(int[]person:people){
            if(list.size()<=person[1]){
                list.add(person);
            }else {
                list.add(person[1],person);
            }
        }
        int[][]ans=new int[n][];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
