package 代码随想录二刷.贪心;

import java.util.*;
import java.util.Comparator;

public class 重建队伍 {
    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int  compare(int[]o1,int[]o2){
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        int n=people.length;
        List<int[]>list=new ArrayList<>();
        for(int[]p:people){
            if(list.size()<=p[1]){
                list.add(p);
            }else {//表示
                list.add(p[1],p);
            }
        }
        int[][]ans=new int[n][];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
