package testproject;

public class 统计放置房子的方式数 {
    public int countHousePlacements(int n) {
       int p=(int)1e9+7;
       long[]f=new long[n+1];
       f[0]=1;
       f[1]=2;
       for(int i=2;i<=n;i++){
           f[i]=(f[i-1]+f[i-2])%p;
       }
       return (int) (f[n]*f[n]%p);
    }
}
