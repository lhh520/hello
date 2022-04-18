import org.junit.Test;

public class test415 {
    public String addStrings(String num1, String num2) {
    int i=num1.length()-1,j=num2.length()-1;
    StringBuilder sb=new StringBuilder();
    int add=0;
    while(i>=0||j>=0||add!=0)
    {
        int x=i>=0?num1.charAt(i)-'0':0;
        int y=j>=0?num2.charAt(j)-'0':0;
        sb.append((x+y+add)%10);
        add=(x+y+add)/10;
        i--;
        j--;
    }
        //System.out.println(sb.toString());
        return sb.reverse().toString();
    }
    @Test
    public void test()
    {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1,num2));
    }
}
