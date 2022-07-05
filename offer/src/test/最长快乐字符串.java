package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最长快乐字符串 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();
        Pair[]arr={new Pair(a,'a'),new Pair(b,'b'),new Pair(c,'c')};
        while (true){
            //按照频次进行排序
            Arrays.sort(arr,(p1,p2)->p2.freq-p1.freq);
            boolean hasNext=false;
            for(Pair pair:arr){
                if(pair.freq<=0){
                    break;
                }
                int m=sb.length();
                //如果当前的数字已经出现了两个和当前一样连着的
                if(m>=2&&sb.charAt(m-2)==pair.ch&&sb.charAt(m-1)==pair.ch){
                    continue;
                }
                hasNext=true;
                sb.append(pair.ch);
                pair.freq--;
                break;
            }
            if(!hasNext){
                break;
            }
        }
        return sb.toString();
    }
    class Pair {
        int freq;
        char ch;

        public Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }
    //优先队列方法
    public String longestDiverseString1(int a, int b, int c){
        PriorityQueue<int[]>pq=new PriorityQueue<>((x,y)->(y[1]-x[1]));
        if(a>0){
            pq.add(new int[]{0,'a'});
        }
        if(b>0){
            pq.add(new int[]{1,'b'});
        }
        if(c>0){
            pq.add(new int[]{2,'c'});
        }
        StringBuilder sb=new StringBuilder();
        while (!pq.isEmpty()){
            int[] cur=pq.poll();
            int n=sb.length();
            //char cc= (char) (cur[0]+'a');
            //判定如果不满足
            if(n>2&&sb.charAt(n-1)-'a'==cur[0]&&sb.charAt(n-2)-'a'==cur[0]){
                if(pq.isEmpty()){
                    break;
                }
                int[]next=pq.poll();
                sb.append(next[0]+'a');
                if(--next[1]!=0){
                    pq.add(next);
                }
            }else {
                sb.append(cur[0]+'a');
                if(--cur[1]!=0){
                    pq.add(cur);
                }
            }
        }
        return sb.toString();
    }



}
