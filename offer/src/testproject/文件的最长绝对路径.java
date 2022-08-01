package testproject;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 文件的最长绝对路径 {

    public int lengthLongestPath(String input){
        String[]paths=input.split("\n");
        System.out.println(1);
        Map<Integer,Integer> levelmap=new HashMap<>();
        int ans=0;
        for(String path:paths){
            int tabcnt=countTab(path);//带的t的个数 表明了所处的层级
            if(path.contains(".")){
                int curLen=levelmap.getOrDefault(tabcnt-1,0)+path.length()-tabcnt;
                ans=Math.max(ans,curLen);
            }else {
                levelmap.put(tabcnt,levelmap.getOrDefault(tabcnt-1,0)+path.length()-tabcnt+1);
            }
        }
        return ans;
    }
    public int countTab(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0;; i++){
            sb.append("\t");
            if(s.startsWith(sb.toString()))
                count++;
            else
                break;
        }

        return count;
    }
    @Test
    public void test(){
        String ss="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(ss));

    }

}
