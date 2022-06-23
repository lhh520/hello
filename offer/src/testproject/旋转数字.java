package testproject;

import org.junit.Test;

public class 旋转数字 {
    public int rotatedDigits(int n) {
        //如果存在 3 4 7必然不可以的
        int res=0;
        for(int i=1;i<n+1;i++){
            if(hasWrong(i)){//如果有了任何错误的数字 则不可能成功
                continue;
            }
            if(hasRight(i)){//如果有了任何正确的数字
                res++;
            }
        }
        return res;
    }
    public boolean hasWrong(int num){
        String s=String.valueOf(num);//看是否有这个数字
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='7'){//存在 3 4 7必然不满足条件
                return true;
            }
        }
        return false;
    }
    public boolean hasRight(int num){
        String s=String.valueOf(num);//看是否有这个数字
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='2'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='9'){//存在 2 5 6 9必然不满足条件
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(rotatedDigits(10));
    }
}
