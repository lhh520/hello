package testproject;

public class 最长特殊序列II {
    public int findLUSlength(String[] strs) {
        int n=strs.length;
        int ans=-1;
        for(int i=0;i<n;i++){
            boolean check=true;
            for(int j=0;j<n;j++){
                if(i!=j&&isCheck(strs[i],strs[j])){
                    check=false;
                    break;
                }
            }
            if(check){
                ans=Math.max(ans,strs[i].length());
            }
        }
        return ans;
    }
    public boolean isCheck(String s,String t){
        //判断s是不是t的子序列
        if(s.length()>t.length()){//s长度更长时，不能作为子序列
            return false;
        }
        //
        int ps=0,pt=0;
        while (ps<s.length()&&pt<t.length()){
            if(s.charAt(ps)==t.charAt(pt)){
                ps++;
            }
            pt++;
        }
        return ps==s.length();
    }
}
