package dp;
import java.util.*;
public class 括号生成 {
    ArrayList<String>list=new ArrayList<>();
    //StringBuilder sb=new StringBuilder();
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        help(0,0,n,new StringBuilder());
        return list;
    }
    public void help(int left,int right,int n,StringBuilder sb){

        if(left==right&&left==n){
            list.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            help(left+1,right,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            help(left,right+1,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    //
    public int minNumberDisappeared (int[] nums) {
        // write code here
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=i+1){
                return i+1;
            }
        }
        return -1;
    }
}
