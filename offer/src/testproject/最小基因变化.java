package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 最小基因变化 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String>cnt=new HashSet<>();
        Set<String>visited=new HashSet<>();
        char[] keys=new char[] {'A', 'C', 'G', 'T'};
        for(int i=0;i<bank.length;i++){
            cnt.add(bank[i]);
        }
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String>queue=new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int step=1;
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                String cur=queue.poll();
                for(int j=0;j<8;j++){
                    for(int k=0;k<4;k++){//每次更换一个
                        if(keys[k]!=cur.charAt(j)){
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j,keys[k]);
                            if(cnt.contains(sb.toString())&&!visited.contains(sb.toString())){
                                if(sb.toString().equals(end)){
                                    return step;
                                }
                                queue.offer(sb.toString());
                                visited.add(sb.toString());
                                queue.add(sb.toString());
                            }
                        }

                    }
                }
            }
            step++;
        }
        return step;
    }
    @Test
    public void test(){
        String start = "AACCGGTT", end = "AACCGGTA";
        String[]bank =new String[]{"AACCGGTA"};
        System.out.println(minMutation(start,end,bank));
    }
}
