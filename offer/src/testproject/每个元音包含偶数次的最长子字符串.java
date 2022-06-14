package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 每个元音包含偶数次的最长子字符串 {
    //s = "eleetminicoworoep"
    // 'a'，'e'，'i'，'o'，'u'
    public int findTheLongestSubstring(String s) {
        int[][]count=new int[s.length()][5];
        if(s.charAt(0)=='a') count[0][0]=1;
        if(s.charAt(0)=='e') count[0][1]=1;
        if(s.charAt(0)=='i') count[0][2]=1;
        if(s.charAt(0)=='o') count[0][3]=1;
        if(s.charAt(0)=='u') count[0][4]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='a'){
                count[i][0]=count[i-1][0]+1;
                count[i][1]=count[i-1][1];
                count[i][2]=count[i-1][2];
                count[i][3]=count[i-1][3];
                count[i][4]=count[i-1][4];
            }else if(s.charAt(i)=='e'){
                count[i][1]=count[i-1][1]+1;
                count[i][0]=count[i-1][0];
                count[i][2]=count[i-1][2];
                count[i][3]=count[i-1][3];
                count[i][4]=count[i-1][4];
            }else if(s.charAt(i)=='i'){
                count[i][2]=count[i-1][2]+1;
                count[i][1]=count[i-1][1];
                count[i][0]=count[i-1][0];
                count[i][3]=count[i-1][3];
                count[i][4]=count[i-1][4];
            }else if(s.charAt(i)=='o'){
                count[i][3]=count[i-1][3]+1;
                count[i][1]=count[i-1][1];
                count[i][2]=count[i-1][2];
                count[i][0]=count[i-1][0];
                count[i][4]=count[i-1][4];
            }else if(s.charAt(i)=='u'){
                count[i][4]=count[i-1][4]+1;
                count[i][1]=count[i-1][1];
                count[i][2]=count[i-1][2];
                count[i][3]=count[i-1][3];
                count[i][0]=count[i-1][0];
            }else {
                count[i][0]=count[i-1][0];
                count[i][1]=count[i-1][1];
                count[i][2]=count[i-1][2];
                count[i][3]=count[i-1][3];
                count[i][4]=count[i-1][4];
            }
        }
        System.out.println(1);
        int max=0;
        for(int i=0;i<count.length-1;i++){
            for(int j=i+1;j<count.length;j++){
                int[]c1=count[i];
                int[]c2=count[j];
                int ii=0;
                boolean flag=true;
                for(;ii<c1.length;ii++){
                    if((c2[ii]-c1[ii])%2!=0){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    max=Math.max(max,j-i);
                }
            }
        }
        return max;
    }
    //
    public int findTheLongestSubstring1(String s){
        int n=s.length();
        System.out.println(1);
        //1左移5次 相当于2^5，从00000-11111种状态，代表5个元音字母的个数是否为偶数，0代表偶数，1代表奇数
        int[] pos=new int[1<<5];
        Arrays.fill(pos,-1);
        int ans=0,status=0;
        pos[0]=0;
        //有n个字符 循环n次，状态值初始为0
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                //与1异或，相同为0，不同为1
                status ^=(1<<0);
            }else if(ch=='e'){
                status ^=(1<<1);
            }else if(ch=='i'){
                status ^=(1<<2);
            }else if(ch=='o'){
                status ^=(1<<3);
            }else if(ch=='u'){
                status ^=(1<<4);
            }
            //如果status对应的pos[status]大于0 说明已经找到符合要求的子串
            //因为两个子串的奇偶性相等，说明中间子串是符合要求的。
            //奇偶性相同的两个数的差，必定为偶数 只会有一个偶数00000
            //因此出现两个相同状态的数，他们中间必定出现了偶数次数的aeiou
            if(pos[status]>=0){
                ans=Math.max(ans,i+1-pos[status]);
            }else{
                //pos[status]==-1 说明status是第一次出现，只保存这个值
                pos[status]=i+1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String s = "leetcodeisgreat";
        System.out.println(1<<2);
        //System.out.println(findTheLongestSubstring1(s));
    }
}
