package 新刷题;

public class 统计美丽子字符串 {
    public int beautifulSubstrings(String s, int k) {
        //快慢指针 就是枚举所有的数据
        int res=0;
        for(int i=0;i<s.length();i++){
            int a=0,b=0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='a'||s.charAt(j)=='e'||s.charAt(j)=='i'||s.charAt(j)=='o'||s.charAt(j)=='u')
                    a++;
                else
                    b++;
                if((a*b)%k==0 && a==b)
                    res++;

            }
        }
        return res;
    }
}
