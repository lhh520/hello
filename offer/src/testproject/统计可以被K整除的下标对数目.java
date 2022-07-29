package testproject;

public class 统计可以被K整除的下标对数目 {
    public long countPairs(int[] nums, int k) {
        long ans=0;
        int count[]=new int[k+5];
        for(int i=0;i<nums.length;i++)
        {count[gcd(nums[i],k)]++;}//将因子 进行相加
        for(int i=1;i<=k;i++){
            if(count[i]==0){continue;}//此时可能是i不能被k整除，也可能是这样的gcd无有
            if((long)i*(long)i%k==0){//如果自己本身可以成功 则数据为n个中选择两个
                ans+=(long)count[i]*(long)(count[i]-1)/2;
            }
            int m=k/i;
            //注意我们只关注m的倍数中比i大的部分，也就是m*j>i的部分
            for(int j=i/m+1;;j++){
                int n=j*m;
                if(n>k){break;}
                ans+=(long)count[i]*(long)count[n];
            }
        }
        return ans;
    }
    public int gcd(int a,int b){
        return a<=b?(b%a==0?a:gcd(b%a,a)):gcd(b,a);
    }
}
