package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 无矛盾的最佳球队 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        if(n==1){
            return scores[0];
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        //先按照年龄排序，再按照分数排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ages[o1]==ages[o2]?scores[o1]-scores[o2]:ages[o1]-ages[o2];
            }
        });
        int ans=0;
        int[]dp=new int[n];
        for(int i=0;i<n;i++){
            int idx=list.get(i);
            dp[i]=scores[idx];
            for(int j=0;j<i;j++){
                int last=list.get(j);
                //年纪大 并且分数比较低时候  考虑进行排序
                if(scores[last]<=scores[idx]){
                    dp[i]=Math.max(dp[i],dp[j]+scores[idx]);
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]scores=new int[]{1};
        int[]edgs=new int[]{4};
        System.out.println(bestTeamScore(scores,edgs));
    }
}
