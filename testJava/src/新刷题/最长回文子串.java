package 新刷题;

import org.junit.Test;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        //动态规划
        boolean[][]isPalindrome=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i]=true;
        }
        //有一个需要注意的点是[0,3]取决于[1，2]，因此，需要保证[1,2]先于被判断
        //[0,1],[0,2],[0,3],即上面的遍历方法无法实现这个逻辑
        //下面的遍历顺序是[0,1],[0,2],[1,2]...可以满足这个遍历顺序，因此可以计算出正确的结果
        //以上的逻辑可以从"aaaa"这个例子中得到答案
        //启示：在做动态规划时，需要验证初始化顺序
        for(int j=0;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2){
                        isPalindrome[i][j]=true;
                    }else {
                        isPalindrome[i][j]=isPalindrome[i+1][j-1];
                    }
                }
            }
        }


//        for(int i=0;i<s.length();i++){
//            for(int j=i;j<s.length();j++){
//                if(s.charAt(i)==s.charAt(j)){
//                    if(j-i<=2){
//                        isPalindrome[i][j]=true;
//                    }else {
//                        isPalindrome[i][j]=isPalindrome[i+1][j-1];
//                    }
//                }
//
//            }
//        }
        String ans="";
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(maxLen<j-i+1&&isPalindrome[i][j]){
                    maxLen=j-i+1;
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String s="aaaa";
        System.out.println(longestPalindrome(s));
    }
}
