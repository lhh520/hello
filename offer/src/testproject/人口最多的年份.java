package testproject;

import org.junit.Test;

import java.util.Stack;

public class 人口最多的年份 {
    public int maximumPopulation(int[][] logs) {
        int offset=1950;
        int[] peopleDealt= new int[102];
        for(int[]log:logs){
            int i=log[0],j=log[1];
            for(int k=i;k<j;k++){
                peopleDealt[k-offset]++;
            }
        }
        int ans=-1,ret=-1;
        for(int i=0;i<peopleDealt.length;i++){
            if(peopleDealt[i]>ans){
                ans=peopleDealt[i];
                ret=offset+i;
            }
        }
        return ret;
    }
    //
    public  int max(int[][]logs){
        int offset=1950;
        int[]peopleDelate=new int[102];
        for(int i=0;i<logs.length;i++){
            peopleDelate[logs[i][0]-offset]++;
            peopleDelate[logs[i][1]-offset]--;
        }
        int peopleCount=0,maxCount=0,whichYear=0;
        for(int i=0;i<peopleDelate.length;i++){
            peopleCount+=peopleDelate[i];
            if(peopleCount>maxCount){
                maxCount=peopleCount;
                whichYear=i+offset;
            }
        }
        return whichYear;
    }
    //去除重复的字符
    public String removeDuplicateLetters(String s) {
        //先保存最后面的数字
        int[]last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>stack=new Stack<>();
        //还需要一个数组 标记是否已经访问过
        boolean[]flag=new boolean[26];
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            if(!flag[cc-'a']){//表示还未访问
                while (!stack.isEmpty()&&cc<stack.peek()&&last[stack.peek()-'a']>i){
                    char c=stack.pop();
                    flag[c-'a']=false;//表示当前值不再包含
                }
                stack.push(cc);
                flag[cc-'a']=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
    //移除k个数字
    public String removeKdigits(String num, int k){
        if(k==num.length()){
            return new String("0");
        }
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            int cur=num.charAt(i)-'0';
            while (k>0&&(!stack.isEmpty())&&cur<stack.peek()){
                k--;
                stack.pop();
            }
            if(stack.isEmpty()&&cur==0){//为了消除前导0
                continue;
            }
            stack.push(cur);
        }
        while (k>0&&!stack.isEmpty()){//如果已经不满足条件 则从后向前开始删除
            k--;
            stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        for(int nn:stack){
            sb.append(nn);
        }
        return sb.length()==0?"0":sb.toString();
    }
    @Test
    public void test(){
        int[][]logs=new int[][]{{1993,1999},{2000,2010}};
//        System.out.println(maximumPopulation(logs));
//        String s = "bcabc";
//        System.out.println(removeDuplicateLetters(s));
        String removeKdigits="1432219";
        System.out.println(removeKdigits(removeKdigits,3));
    }
}
