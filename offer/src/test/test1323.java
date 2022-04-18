package test;

public class test1323 {
    public int maximum69Number (int num) {
    String temp=Integer.toString(num);
    StringBuilder sb = new StringBuilder(temp);

    for(int i=0;i<temp.length();i++)
    {
        if(temp.charAt(i)=='6')
        {sb.setCharAt(i,'9');
         break;
        }
    }
       int a= Integer.parseInt(sb.toString());
    return a;
    }
}
