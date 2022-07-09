package 热题100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最长快乐字符串 {
    public String longestDiverseString(int a, int b, int c){
        //先构建数组
        StringBuilder sb=new StringBuilder();
        PriorityQueue<pair>pq=new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o2.fre - o1.fre;
            }
        });
        pq.add(new pair('a',a));
        pq.add(new pair('b',b));
        pq.add(new pair('c',c));
        while (!pq.isEmpty()){//堆不为空
            pair p=pq.poll();
            int m=sb.length();
            if(m>=2&&sb.charAt(m-1)==sb.charAt(m-2)&&sb.charAt(m-1)==p.chars){
                if(pq.isEmpty()){
                    break;
                }
                pair next=pq.poll();
                sb.append(next.chars);
                next.fre--;
                if(next.fre>0){
                    pq.add(next);
                }
                pq.add(p);
            }else {
                sb.append(p.chars);
                p.fre--;
                if(p.fre>0){
                    pq.add(p);
                }
            }

        }
        return sb.toString();
    }
    public class pair{
        char chars;
        int fre;
        public pair(char chars,int fre){
            this.chars=chars;
            this.fre=fre;
        }
    }
    @Test
    public void test(){
        System.out.println(longestDiverseString(1,1,7));
    }
}
