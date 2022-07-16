package 代码随想录;

import java.util.Stack;

public class 子数组的最小值之和 {
    private final int mod=(int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int len=arr.length;
        if(len==1){
            return arr[0];
        }
        Stack<Integer>s=new Stack<>();
        long ans=0;
        for(int i=0;i<len;i++){
            while (!s.isEmpty()&&arr[s.peek()]>=arr[i]){//不满足单调栈，需要弹出
                Integer index=s.pop();
                int rangeLeft=s.isEmpty()?-1:s.peek();
                ans+=(long)(index-rangeLeft)*(i-index)*arr[index];
                ans%=mod;
            }
        }
        while (!s.isEmpty()){
            Integer index=s.pop();
            int rangeLeft=s.isEmpty()?-1:s.peek();
            ans+=(long)(index-rangeLeft)*(len-index)*arr[index];
            ans%=mod;
        }
        return (int)(ans%mod);
    }
}
