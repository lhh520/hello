package 代码随想录二刷.动态规划;

import java.util.*;

public class 百度01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        //System.out.println(ss);
        String[]sss=ss.split(" ");
        int n=Integer.parseInt(sss[0]);
        int m=Integer.parseInt(sss[1]);
        Map<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count=0;
        for(int i=0;i<n;i++){
            String cur=sc.nextLine();
            String[]sssss=cur.split(" ");
            int n1=Integer.parseInt(sssss[0]);
            int m2=Integer.parseInt(sssss[1]);
            if(n1>=m){
                count+=m2;
            }else {
                map.put(n1,m2);
                pq.add(n1);
            }
        }
        try {
            for(Map.Entry<Integer,Integer>entry:map.entrySet()){

                int key=entry.getKey(),val=entry.getValue();
                if(pq.isEmpty()||pq.peek()+entry.getKey()<m){
                    break;
                }
                while (!map.containsKey(pq.peek())){
                    pq.poll();
                }
                if(key+pq.peek()>=m){
                    int min=Math.min(val,map.get(pq.peek()));
                    count+=min;
                    map.put(key,val-min);
                    map.put(pq.peek(),map.get(pq.peek())-min);
                    if(map.get(key)==0){
                        map.remove(key);
                    }
                    if(map.get(pq.peek())==0){
                        map.remove(pq.peek());
                        pq.poll();
                    }
                }
            }
        }catch (Exception e){

        }

        System.out.println(count);
    }

}
