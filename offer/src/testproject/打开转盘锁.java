package testproject;

import org.junit.Test;

import java.util.*;

public class 打开转盘锁 {
    //思路：广度优先搜索 将0000加入进去 然后使用 将0000能转化成的数字放入队列中
    //每个位置都可能向前或者向后移动一位 实现旋转
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)){
            return 0;
        }
        Set<String>set=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);//将所有的锁死的情况 填入集合中
        }
        if(set.contains("0000")){
            return -1;//包含最初的情况,不可能
        }
        Queue<String>queue=new LinkedList<>();//存储状态
        queue.add("0000");//放入了最初的状态
        Set<String>hasset=new HashSet<>();//防止往回走 进入死循环
        int step=0;
        while (!queue.isEmpty()){
            step++;
            int sz= queue.size();
            for(int i=0;i<sz;i++){
                String temp=queue.poll();//弹出
                //开始寻找下一个值
                for(String next:getNext(temp)){//获取到下一个的值
                    if(!hasset.contains(next)&&!set.contains(next)){//不是死亡数字 也不是
                        if(next.equals(target)){
                            return step;
                        }
                        queue.offer(next);
                        hasset.add(next);
                    }
                }
            }
        }
        return -1;
    }
    public char numPrev(char cur){
        return cur=='9'?'0':(char)(cur-1);
    }
    public char numNext(char cur){
        return cur=='9'?'0':(char)(cur+1);
    }
    public List<String> getNext(String cur){
        List<String>ret=new ArrayList<>();
        char[]chars=cur.toCharArray();
        for(int i=0;i<4;i++){
            char num=chars[i];
            chars[i]=numPrev(num);//循转一位
            ret.add(new String(chars));//完成一位的旋转后 填入结果集中
            chars[i]=numNext(num);//循转一位 到下一位
            ret.add(new String(chars));
            chars[i]=num;
        }
        return ret;
    }
    @Test
    public void test(){
        String[] deadends=new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends,"0202"));
    }
}
