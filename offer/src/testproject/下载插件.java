package testproject;

public class 下载插件 {
    public int leastMinutes(int n) {
        int per=1,ans=0;
        while (n>0){
            if(n<=per){
                ans+=1;
                n=-per;
            }else {
                ans+=1;
                per*=2;
            }
        }
        return ans;
    }
}
