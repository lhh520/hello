package 代码随想录二刷.动态规划;

import java.util.*;

public class 百度03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss222=sc.nextLine();
        int n=Integer.parseInt(ss222);
        int[]in=new int[n+1];
        //Arrays.fill(in,1);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            String ss=sc.nextLine();
            //System.out.println(ss);
            String[]sss=ss.split(" ");
            int to=Integer.parseInt(sss[0]);
            int from=Integer.parseInt(sss[1]);
            map.put(from,to);
            in[to]++;
        }
        int[]ret=new int[n];
        Queue<Integer>queue=new LinkedList<>();
        boolean[]flag=new boolean[n+1];
        for(int i=1;i<in.length;i++){
            if(in[i]<=1){
                flag[i]=true;
                queue.add(i);
            }
        }
        int cur=1;

        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                int num=queue.poll();
                ret[num-1]=cur;
                if(map.containsKey(num)){
                    in[map.get(num)]--;
                    if(in[map.get(num)]<=1&&!flag[map.get(num)]){
                        queue.add(map.get(num));
                        flag[map.get(num)]=true;
                    }
                }

            }
            cur++;
        }
        for(int i=0;i<ret.length;i++){
            System.out.print(ret[i]);
            if(i!=ret.length-1){
                System.out.print(" ");
            }
        }
        System.out.println(Arrays.toString(ret));
    }
}
