package test;

import org.junit.Test;

import java.util.*;

public class test736 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,int[]>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
           if(map.isEmpty()||!map.containsKey(s.charAt(i))){
               int[]temp=new int[]{i,i};
               map.put(s.charAt(i),temp);
           }
           //
            int[]newtemp=new int[]{map.get(s.charAt(i))[0],i+1};
             map.put(s.charAt(i),newtemp);
        }
        int n=map.size();
        int[][]lists=new int[n][2];
        int ii=0;
        for(Map.Entry<Character,int[]>entry: map.entrySet()){
            lists[ii]= entry.getValue();
            ii++;

        }

        Arrays.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int count=0;
        int start=lists[0][0];
        List<int[]>list=new ArrayList<>();
        for(int i=1;i<lists.length;i++){
            if(lists[i][0]>=lists[i-1][1]){//表示出现了新的区间点
                list.add(new int[]{start,lists[i-1][1]});//添加新的区间
                start=lists[i][0];//更新新的起点
            }else {
                lists[i][1]=Math.max(lists[i][1],lists[i-1][1]);
            }

        }
        list.add(new int[]{start, lists[lists.length - 1][1]});
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ans.add(list.get(i)[1]-list.get(i)[0]);
        }

        return ans;
    }
    public List<Integer> partitionLabels1(String s){
        List<Integer>list=new ArrayList<>();
        int[]edgs=new int[26];
        char[]chars=s.toCharArray();
        for(int i=0;i<s.length();i++){
            edgs[chars[i]-'a']=i;//这样就记录了每个字母出现的最远的下标
        }
        int idx=0;
        int last=-1;
        for(int i=0;i<chars.length;i++){
            idx=Math.max(idx,edgs[chars[i]-'a']);//这是为了记录最远的那个
            if(i==idx){
                list.add(i-last);
                last=i;
            }

        }
        return list;
    }
    public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        }
    });
    List<int[]>list=new ArrayList<>();
    int start=intervals[0][0];
    for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]>intervals[i-1][1]){//需要开辟新的空间了
            list.add(new int[]{start,intervals[i-1][1]});
            start=intervals[i][0];
        }else {
            intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
        }
    }
    list.add(new int[]{start,intervals[intervals.length-1][1]});
    int[][]ans=new int[list.size()][2];
    for(int i=0;i<list.size();i++){
        ans[i]=list.get(i);
    }
    return ans;
    }
    @Test
    public void test(){
        String s="ababcbacadefegdehijhklij";
        System.out.println(partitionLabels1(s));
    }
}
