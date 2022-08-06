package test;

public class 所有子字符串美丽值之和 {
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[]count=new int[26];
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                count[ch-'a']++;
                int max_value=Integer.MIN_VALUE;
                int min_value=Integer.MAX_VALUE;
                for(Integer value:count){
                    if(value>0&&value>max_value){
                        max_value=value;
                    }
                    if(value>0&&value<min_value){
                        min_value=value;
                    }
                }
                ans+=(max_value-min_value);
            }
        }
        return ans;
    }
}
