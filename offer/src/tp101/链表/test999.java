package tp101.链表;

import java.util.*;

public class test999 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in=sc.nextLine();
        String[]nnn=in.split(" ");
        int n=Integer.parseInt(nnn[0]);
        int k=Integer.parseInt(nnn[1]);
        int t=Integer.parseInt(nnn[2]);
        String se=sc.nextLine();
        String[]see=se.split(" ");
        int[]nums1=new int[see.length];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<see.length;i++){
            nums1[i]=Integer.parseInt(see[i]);
            map.put(i+1,nums1[i]);
        }
        String thir=sc.nextLine();
        String[]thire=thir.split(" ");
        int[]nums2=new int[thire.length];
        for(int i=0;i<thire.length;i++){
            nums2[i]=Integer.parseInt(thire[i]);
        }
        //PriorityQueue<Integer,Map<Integer,Integer>>pqw=new PriorityQueue<>()
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return map.get(o1[0])-map.get(o2[0]);
            }
        });

        int ret=0;
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==0){
                if(pq.isEmpty()){
                    ret+=t;
                }else {
                    int[]cur=pq.poll();
                    ret+=map.get(cur[0]);
                    cur[1]--;
                    if(cur[1]>0){
                        pq.add(new int[]{cur[0],cur[1]});
                    }
                }
            }else {
                List<int[]>list=new ArrayList<>();
                boolean flag=false;
                while (!pq.isEmpty()){
                    list.add(pq.poll());
                    int[]pp=list.get(list.size()-1);

                    if(pp[0]==nums2[i]){
                        pp[1]++;
                        flag=true;
                    }
                }
                if(!flag){
                    list.add(new int[]{nums2[i],1});
                }
                for(int[]pp:list){
                    pq.add(pp);
                }
            }
        }
        System.out.println(ret);
    }
}
