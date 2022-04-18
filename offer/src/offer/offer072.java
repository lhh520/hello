package offer;

public class offer072 {
    public int mySqrt(int x) {
        for(int i=0;i<x/2;i++)
        {
            if(i*i>=x)
                return i;
        }
        return 0;
    }
}
