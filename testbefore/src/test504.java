import org.junit.Test;

public class test504
{
    public String convertToBase7(int num) {
        Boolean flag=true;
    if(num<0)
    {
        flag=false;
        num=-num;
    }
    StringBuilder sb=new StringBuilder();
    while(num!=0)
    {
         sb.append(num%7);
         num=num/7;
    }
    if(flag==false)
        sb.append("-");
    return sb.reverse().toString();
    }
    @Test
    public void test()
    {
        int num=7;
        System.out.println(convertToBase7(num));
    }
}
