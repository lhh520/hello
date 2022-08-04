package testproject;

import java.util.Arrays;

public class 有序队列 {
    public String orderlyQueue(String s, int k){
        if(k==1){
            String smallest=s;
            StringBuilder sb=new StringBuilder();
            int n=s.length();
            for(int i=1;i<n;i++){
                char c=sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if(sb.toString().compareTo(smallest)<0){
                    smallest=sb.toString();
                }
            }
            return smallest;
        }else {
            char[]arr=s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
