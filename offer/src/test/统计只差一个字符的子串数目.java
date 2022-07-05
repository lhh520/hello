package test;

public class 统计只差一个字符的子串数目 {
    public int countSubstrings(String s, String t) {
        int m=s.length();
        int n=t.length();
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int diff=0;
                for(int k=0;i+k<m&&j+k<n;k++){
                    if(s.charAt(i+k)!=s.charAt(j+k)){
                        diff++;
                    }
                    if(diff>1){
                        break;
                    }
                    if (diff==1){
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}
