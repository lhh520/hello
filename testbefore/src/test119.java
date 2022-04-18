import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test119
{
    public List<Integer> getRow(int rowIndex) {
    List<List<Integer>>lists=new ArrayList<>();
       // System.out.println("hello");  ;
    for(int i=0;i<=rowIndex;i++)
    {
        List<Integer>list=new ArrayList<>();
        if(i==0)
        {
            list.add(1);
            lists.add(list);
        }
        else
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                    list.add(1);
                else
                list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
            }
            lists.add(list);
        }
    }
    return lists.get(rowIndex);
    }
    @Test
    public void test()
    {   List<Integer> list=getRow(2);
        System.out.println(list);
    }
}
