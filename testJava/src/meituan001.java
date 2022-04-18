import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class meituan001
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int times=scanner.nextInt();
        List<String>list=new ArrayList<>();
        List<String>ans=new ArrayList<>();
        for(int i=0;i<times;i++)
        {
            list.add(scanner.next());
        }
        //System.out.println(list.toString());
        for(int i=0;i<list.size();i++)
        {
            if(check1(list.get(i))&&check2(list.get(i)))
               ans.add("Accept");
            else
                ans.add("Wrong");
        }
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
    }
    public static boolean check1(String s)
    {   char ch1=s.charAt(0);
        if((ch1>='a'&&ch1<='z')||(ch1>='A'&&ch1<='Z'))
            return true;
        return false;
    }
    public static boolean check2(String s)
    {   int index1=0,index2=0;
        for(int i=0;i<s.length();i++)
        {
            char ch1=s.charAt(i);
            if((ch1>='a'&&ch1<='z')||(ch1>='A'&&ch1<='Z'))
               index1++;
            if(ch1>='0'&&ch1<='9')
                index2++;
        }
        if(index1>=1&&index2>=1)
            return true;
        else
            return false;
    }
}
