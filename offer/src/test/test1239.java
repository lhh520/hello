package test;

import java.util.List;

public class test1239 {
    public int maxLength(List<String> arr) {
    return dfs(arr,0,0);
    }
    public int dfs(List<String> arr,int index,int bitmap){
        if(index==arr.size())
            return 0;
        //表示不遍历当前的字符串
        int p1=dfs(arr,index+1,bitmap);
        //遍历当前字符串
        int p2=0;
        boolean can=true;
        String arrs=arr.get(index);
        for(char c:arrs.toCharArray()){
            if((bitmap&(1<<(c-'a')))!=0){//当前已经有该值
             can=false;
             break;
            }else {
               bitmap|=(1<<(c-'a'));
            }
        }
        if(can){
            p2=arrs.length()+dfs(arr,index+1,bitmap);
        }
        return Math.max(p1,p2);
    }
}
