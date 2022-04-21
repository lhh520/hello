package offer03;

import org.junit.Test;

import java.util.*;

public class offer38 {
    StringBuffer sb=new StringBuffer();
    List<String>ans=new ArrayList<>();
    Set<String> set=new HashSet<>();
    public String[] permutation(String s) {
        char[]arr=s.toCharArray();
        dfs(arr,0);
        int n=ans.size();
        System.out.println(n);
        String[]answer=new String[n];
        for(int i=0;i<n;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    //回溯方法
    public void dfs(char[]arr,int index){
        if(index==arr.length){
            if(set.add(new String(arr)))
            ans.add(new String(arr));
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            dfs(arr,index+1);
            swap(arr,index,i);
        }
    }
    public void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    @Test
    public void test(){
        String s="abc";
        String[] anse=permutation(s);

    }
}
