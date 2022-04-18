public class LCP17 {
    public int calculate(String s) {
        int x=1,y=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='A')
                x = 2 * x + y;
            if(s.charAt(i)=='B')
                y = 2 * y + x;
        }
        return x+y;
    }
}
