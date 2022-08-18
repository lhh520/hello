package hot100;

public class 考试的最大干扰度 {
    int k,n;
    String ss;
    public int maxConsecutiveAnswers(String answerKey, int _k){
        n=answerKey.length();
        k=_k;
        ss=answerKey;
        return Math.max(get('T'),get('F'));
    }
    public int get(char c){
        int ans=0;
        for(int i=0,j=0,cnt=0;i<n;i++){
            if(ss.charAt(i)==c){
                cnt++;
            }
            while (cnt>k){
                if(ss.charAt(j)==c){
                    cnt--;
                    j++;
                }
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}
