package offertest1;

import org.junit.Test;

import java.util.*;

public class offer38 {
    Set<String>set=new HashSet<>();
    public String[] permutation(String s) {
    StringBuilder sb=new StringBuilder();

    char[]chars=s.toCharArray();
    List<String>list=new ArrayList<>();
    int n=s.length();
    dfs(list,0,chars);
    String[]strings=new String[list.size()];
        for (int i = 0; i <list.size(); i++) {
            strings[i]=list.get(i);
        }
        return strings;
    }
    public void dfs(List<String>list,int index,char[]chars){
       if(index==chars.length){
           if(set.add(new String(chars)))
           list.add(new String(chars));
           return;
       }

       for(int i=index;i< chars.length;i++){
           swapnum(chars,index,i);
           dfs(list,index+1,chars);

           swapnum(chars,index,i);
           //list.add(new String(chars));
       }

    }
    public void swapnum(char[]chars,int i,int j){
        Character c=chars[i];
        chars[i]=chars[j];
        chars[j]=c;
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2+1];
    }
    @Test
    public void test(){
        String s="aab";
        String[]ans=permutation(s);
        System.out.println(Arrays.toString(ans));
    }
}
