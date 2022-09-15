package LCP;

import java.util.*;

public class testdudud {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        List<Integer> ret=new ArrayList<>();
        for(int i=0;i<n;i++){
            String str2=sc.nextLine();
            String[]strings=str2.split(" ");
            int from=Integer.parseInt(strings[0]);
            int to=Integer.parseInt(strings[1]);
            int ans=getstep(from,to);
            ret.add(ans);
        }
        for(int i=0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }
    public static int getstep(int from,int to){
        if(from==to){
            return 0;
        }

        long max=Math.max(from,to);
        long min=Math.min(from,to);
        if(min==0){
            return -1;
        }
        if(max%min!=0){
            return -1;
        }

        long cur=max/min;
        String bb=Long.toBinaryString(cur);
        int count=0;
        for(int i=0;i<bb.length();i++){
            if(bb.charAt(i)=='1'){
                count++;
            }
        }
        if(!(count==1&&bb.charAt(0)=='1')){
            return -1;
        }

        Queue<Long> queue=new LinkedList<>();
        queue.add((long) from);
        int step=-1;
        while (!queue.isEmpty()){
            int sz=queue.size();
            step++;
            for(int i=0;i<sz;i++){
                long pop=queue.poll();
                if(pop==to){
                    return step;
                }
                queue.add(pop*2);
                queue.add(pop*4);
                queue.add(pop*8);
                if(pop%2==0){
                    queue.add(pop/2);
                }
                if(pop%4==0){
                    queue.add(pop/4);
                }
                if(pop%8==0){
                    queue.add(pop/8);
                }
            }
        }
        return -1;
    }
}
