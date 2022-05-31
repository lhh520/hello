package test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 跳跃游戏VII {
    //s = "011010", minJump = 2, maxJump = 3
    int minJump;
    int maxJump;
    //boolean flag=false;
    public boolean canReach(String s, int minJump, int maxJump) {
        char[]cc=s.toCharArray();
        this.minJump=minJump;
        this.maxJump=maxJump;
        return backtrace(cc,0);
    }
    public boolean backtrace(char[]cc,int index){
        if(index>=cc.length){
            return true;
        }
        boolean flag=false;
        for(int i=index+minJump+1;i<=index+maxJump+1;i++){
            if(i>=cc.length){
                return true;
            }
            if(cc[i]=='0'){
                flag=flag||backtrace(cc,i);
            }
        }
        return flag;
    }
    //BFS
    public boolean canReach1(String s, int minJump, int maxJump){
        int n=s.length();
        if(s.charAt(n-1)==1) return false;
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='1') continue;
            while (!queue.isEmpty()&&queue.peek()<i-maxJump){
                queue.poll();
            }
            if(queue.isEmpty()){
                return false;
            }
            if(queue.peek()<=i-minJump){
                queue.offer(i);
            }else if(i==n-1) return false;
        }
        return true;
    }

    public boolean canReach3(String s, int minJump, int maxJump) {
        int len = s.length();
        // 最后 s.length - 1 处，如果不是 ‘0’ 则不可能为 true
        if(s.charAt(len-1) == '1'){
            return false;
        }

        //  can[i] 为 true 表示 下表 i 处可达到
        boolean[] can = new boolean[len];
        // 【题意】下标 0 处，且该位置的值一定为 '0'
        can[0] = true;
        for(int i=0,limit=0;i<len;i++){
            if(can[i] == false){
                continue;
            }

            // 向前探索是否可达，对于已经探索过的位置[0 ～ limit) 则跳过
            int left = Math.max(limit, i + minJump), right = Math.min(i+maxJump, len-1);
            for(int j=left; j <= right;j++){
                can[j] = s.charAt(j) == '0';
            }

            // limit 表示坐标 [0 ～ limit) 的位置已经判断过是否可到达
            limit = right + 1;
        }

        return can[len -1];
    }


    @Test
    public void test(){
        String s = "01101110";
        int minJump = 2, maxJump = 3;
        System.out.println(canReach(s,minJump,maxJump));
    }
}
