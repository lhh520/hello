package testproject;

import org.junit.Test;

public class 单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        int index1=-1;
        int index2=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i< words.length;i++){
            if(words[i].equals(word1)){
                index1=i;
            }
            if(words[i].equals(word2)){
                index2=i;
            }
            if(index1!=-1&&index2!=-1){
                ans=Math.min(ans,Math.abs(index1-index2));
                }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    @Test
    public void test(){
        String[]word=new String[]{"I","am","a","student","from","a","university","in","a","city"};
        String s1="a";
        String s2="student";
        System.out.println(findClosest(word,s1,s2));
    }
}
