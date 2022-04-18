import org.junit.Test;

public class test860 {
    public boolean lemonadeChange(int[] bills) {
    int sum=0;
    int[]cash=new int[]{0,0,0};
    for(int i=0;i<bills.length;i++)
    {
       if(bills[i]==5)
       {
           sum=sum+5;
           cash[0]++;
       }
       if(bills[i]==10)
       {
           cash[1]++;
           sum=sum+5;
           cash[0]--;
           if(cash[0]<0)
               return false;
       }
        if(bills[i]==20)
        {
            cash[2]++;
            sum=sum+5;
            cash[1]--;
            cash[0]--;
            if(cash[1]<0)
            {   cash[0]=cash[0]-2;
                if(cash[0]<0)
                    return false;
                else
                    cash[1]++;
            }
        }
    }
    return true;
    }
    public int numberOfMatches(int n) {
        int sum=0;
        int temp;
        while(n!=1)
        {

           if(n%2==0)
           {   temp=n/2;
               n=n/2;


           }
           else
            {   temp=(n-1)/2;
                n=(n-1)/2+1;

            }
           sum=sum+temp;
            System.out.println(n);
        }
        return sum;
    }
    @Test
    public void test()
    {
        //int[] bills=new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(numberOfMatches(7));
    }
}
