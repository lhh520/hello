package 代码随想录二刷.数组;

public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left=0,right=num;
        while (left<=right){
            int mid=(left+right)/2;
            if(mid*mid==num){
                return true;
            }
            if(mid*mid<num){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }
}
