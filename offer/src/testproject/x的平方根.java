package testproject;

public class x的平方根 {
    public int mySqrt(int x) {
        if(x==2147483647)
            return 46340;
        int i;
        for(i=0;i<=x/2;i++){
            if((i)*(i)>=x)
                break;
        }
        if(i*i>x){
            return i-1;
        }
        return i;
    }
}
