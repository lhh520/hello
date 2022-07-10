package 热题100;

public class 找出数组中的第一个回文字符串 {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(check(words[i])){
                return words[i];
            }
        }
        return "";
    }
    public boolean check(String word){
        int i=0,j=word.length()-1;
        while (i<j){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
