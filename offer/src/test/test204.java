package test;

import java.util.Arrays;

public class test204 {
    public int countPrimes(int n)
    {
        int[]isParime=new int[n];
        //先将所有的数字都作为1
        Arrays.fill(isParime,1);
        int ans=0;
        for (int i=2;i<n;i++)
        {
            if(isParime[i]==1)
            {
                ans+=1;
                if((long)i*i<n)
                {
                    for(int j=i*i;j<n;j=j+i)
                        isParime[j]=0;
                }
            }
        }
        return ans;
    }
}
