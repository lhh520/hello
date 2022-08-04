package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 构造限制重复的字符串 {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character>pq=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2-o1;
            }
        });
        char[]chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            pq.add(chars[i]);
        }
        StringBuilder sb=new StringBuilder();
        int count=1;
        while (!pq.isEmpty()){
            //不出现意外的情况
            if(sb.length()==0||sb.charAt(sb.length()-1)!=pq.peek()){
                count=1;
                char cc=pq.poll();
                sb.append(cc);
                continue;
            }
            if(sb.length()>0&&sb.charAt(sb.length()-1)==pq.peek()){
                if(count<repeatLimit){
                    char cc=pq.poll();
                    sb.append(cc);
                    count++;
                }else {//表示已经比较大了
                    List<Character>list=new ArrayList<>();
                    while (!pq.isEmpty()&&sb.charAt(sb.length()-1)==pq.peek()){
                        char cc=pq.poll();
                        list.add(cc);
                    }
                    if(pq.isEmpty()){//说明只剩下一个字符了
                        break;
                    }else {
                        count=1;
                        char cc=pq.poll();
                        sb.append(cc);
                        for(int i=0;i<list.size();i++){
                            pq.add(list.get(i));
                        }
                    }
                }
            }



        }
        return sb.toString();
    }

    public String repeatLimitedString1(String s, int repeatLimit){
        int n = s.length();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node a, Node b){
                return b.c - a.c;
            }
        });
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(int i = 0 ; i < 26; i++){
            if(arr[i] != 0){
                pq.add(new Node((char)(i + 'a'), arr[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            //当前字典序最大的字符可用次数 < repeatLimit
            if(temp.count <= repeatLimit){
                for(int i = temp.count; i > 0; i--){
                    sb.append(temp.c);
                }
                continue;
            }else{
                for(int i = repeatLimit; i > 0; i--){
                    sb.append(temp.c);
                }
                // 如果还有别的字符，插一个别的字符
                if(pq.size() > 0){
                    sb.append(pq.peek().c);
                    pq.peek().count--;
                    if(pq.peek().count == 0){
                        pq.poll();
                    }
                }else{
                    // 没有别的字符，结束构造
                    break;
                }
                //当前字符剩余可用次数 > 0, 将其入队
                pq.add(new Node(temp.c, temp.count - repeatLimit));
            }
        }
        return sb.toString();
    }


    class Node {
        char c;//字符
        int count;//剩余可用的次数

        public Node(char c, int count) {
            this.c = c;
            this.count = count;

        }


    }}