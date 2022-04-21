package offer03;

import java.util.ArrayList;
import java.util.List;

public class offer38 {
    StringBuffer sb=new StringBuffer();
    List<String>ans=new ArrayList<>();
    public String[] permutation(String s) {
        dfs(s,0);
        int n=ans.size();
        String[]answer=new String[n];
        for(int i=0;i<n;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    //回溯方法
    public void dfs(String s,int index){
        if(index==s.length()-1){

        }
    }
}
