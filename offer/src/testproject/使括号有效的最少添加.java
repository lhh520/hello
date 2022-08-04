package testproject;

public class 使括号有效的最少添加 {
    public int minAddToMakeValid(String s) {
        int L=0,R=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                L++;
            }else {
                if(L>0){
                    L--;
                }else {
                    R++;
                }
            }
        }
        return L+R;
    }
}
