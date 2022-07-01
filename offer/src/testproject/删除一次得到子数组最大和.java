package testproject;

public class 删除一次得到子数组最大和 {
    public int maximumSum(int[] arr) {
        int a=arr[0];
        int b=0;
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            b=Math.max(a,b+arr[i]);
            a=Math.max(a+arr[i],arr[i]);
            ans=Math.max(ans,Math.max(a,b));
        }
        return ans;
    }
}
