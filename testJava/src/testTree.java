import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class testTree
{

    @Test()//TreeSet
    public void test()
    {
        TreeSet<Integer>set=new TreeSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        Iterator iterator=set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void testHashSet()
    {
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        Iterator iterator=set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    @Test//
    public void testTree()
    {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));

        System.out.println(ts.size());

    }
    }

