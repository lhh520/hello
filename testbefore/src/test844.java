import org.junit.Test;

import java.util.Stack;

public class test844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        Stack<Character>stack=new Stack<>();
        Stack<Character>stack1=new Stack<>();
        int i=0;

        while(i<s.length())
        {    if(s.charAt(i)=='#'&&stack.isEmpty())
        {
            i++;
        }
            if(s.charAt(i)=='#'&&!stack.isEmpty())
            {   stack.pop();
                i++;
            }
            else
            {
                stack.push(s.charAt(i));
                i++;
            }
        }
        int n1=stack.size();
        for(i=0;i<=n1;i++)
        {   if(stack.isEmpty())
            {
                sb1.append("");
                break;
            }
            sb1.append(stack.pop());
        }
        int j=0;
        while(j<t.length())
        {    if(t.charAt(j)=='#'&&stack1.isEmpty())
        {
            j++;
        }
            if(t.charAt(j)=='#'&&!stack1.isEmpty())
            {   stack1.pop();
                j++;
            }
            else
            {
                stack1.push(t.charAt(j));
                j++;
            }
        }
        int n2=stack1.size();
        for(i=0;i<=n2;i++)
        {    if(stack1.isEmpty())
        {
            sb2.append("");
            break;
        }
            sb2.append(stack1.pop());
        }

        String s1=sb1.reverse().toString();
        String s2=sb2.reverse().toString();
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }
    @Test
    public void test()
    {  //"y#fo##f"
        //"y#f#o##f"
       //

        String s2 = "y#fo##f", t2 ="y#f#o##f";
        System.out.println(backspaceCompare(s2,t2));
        //"bxj##tw"
        //"bxj###tw"
    }
}
