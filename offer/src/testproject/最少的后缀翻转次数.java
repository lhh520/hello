package testproject;

public class 最少的后缀翻转次数 {
    public int minFlips(String target) {
        int flips=0;
        char prev='0';
        int n=target.length();
        for(int i=0;i<n;i++){
            char curr=target.charAt(i);
            if(curr!=prev){
                flips++;
                prev=curr;
            }
        }
        return flips;
    }
}
