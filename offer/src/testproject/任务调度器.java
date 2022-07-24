package testproject;

import java.util.HashMap;
import java.util.Map;

public class 任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[]temp=new int[26];
        int countMaxTask=0;
        int maxTask=0;
        for(char c:tasks){
            temp[c-'A']++;
            maxTask=Math.max(temp[c-'A'],maxTask);
        }
        for(int i=0;i<26;i++){
            if(temp[i]==maxTask){
                countMaxTask++;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}
