package testproject;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        //维护一个双端队列
        Deque<Character> deque = new LinkedList<Character>();
        int leght = num.length();
        for (int i = 0; i < leght; i++) {
            char c = num.charAt(i);
            //当且仅当K>0 并且队尾元素大于要入队的元素的时候就把队尾元素移除掉
            while (!deque.isEmpty()&& k>0 && deque.peekLast()>c){
                System.out.println(deque.getLast());
                deque.pollLast();
                //System.out.println(tt);
                k--;
            }
            //如果不大于则直接入队
            deque.offerLast(c);
        }
        //此时如果K还大于0 队列里面的元素已经为单调不降了。则最后依次移除队列尾部剩余的k数次即可，
        //拿123456728 k=7 举例说明
        //入队完后 队列里面为1228 此时k=2 所以还需要依次移除尾部2和8  剩余12即为最小
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        boolean flag =true;
        StringBuffer res = new StringBuffer();
        //从队列头部取出所有元素
        while (!deque.isEmpty()){
            Character character = deque.pollFirst();
            //防止前导0 也就是队头第一个元素==0 则需要跳过。
            if(flag && character=='0'){
                continue;
            }
            flag=false;
            res.append(character);
        }
        //返回结果
        return res.length()==0?  "0" :res.toString();
    }
    //维护一个队列 从左开始，保证队列单调递增
    public String removeKdigits1(String num, int k){
        Deque<Character>deque=new LinkedList<>();
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            while (k>0&&!deque.isEmpty()&&deque.peekLast()>c){
                 deque.pollLast();
                 k--;
            }
            deque.offerLast(c);
        }
        for(int i=0;i<k;i++){
            deque.pollLast();
        }
        StringBuffer sb=new StringBuffer();
        boolean flag=true;
        while (!deque.isEmpty()){
            Character c=deque.pollFirst();
            if(flag&&c=='0'){
                continue;
            }
            flag=false;
            sb.append(c);
        }
        return sb.length()==0?"0":sb.toString();
    }






    @Test
    public void test(){
        String num="1432219";
        System.out.println(removeKdigits1(num,3));
    }
}
