package test;

import org.junit.Test;

import java.util.*;

public class test830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>>ans=new ArrayList<>();
        Set<Character>tt=new HashSet<>();
    Map<Character,List<Integer>> map=new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            if(!map.containsKey(s.charAt(i)))
            {
                List<Integer>list=new ArrayList<>();
                list.add(i);
                list.add(i);
                list.add(0);
                map.put(s.charAt(i),list);
            }
            //
            else
            {
                List<Integer>list1=map.get(s.charAt(i));
                list1.set(1,i);
                int ll=list1.get(2);
                list1.set(2,ll+1);
                map.put(s.charAt(i),list1);
                if(list1.get(2)>=3)
                { tt.add(s.charAt(i));
                   // System.out.println(map.get(s.charAt(i)).toString());
                }
            }
        }
        Iterator it = tt.iterator();

        while (it.hasNext()) {
           // ans.add();
            Character c= (Character) it.next();
            List<Integer>list1=map.get(c);
            List<Integer>nn=new ArrayList<>();
            nn.add(list1.get(0));
            nn.add(list1.get(1));
            ans.add(nn);
        }
        return ans;
    }
    public List<List<Integer>> largeGroupPositions1(String s)
    {
        List<List<Integer>>ret=new ArrayList<>();
        int n=s.length();
        int num=1;
        for (int i = 0; i <n; i++) {
            if(i==n-1||s.charAt(i)!=s.charAt(i+1))
            {  if(num>=3)
                    ret.add(Arrays.asList(i-num+1,i));
            num=1;}
            else
                num++;
        }
        return ret;
    }
    @Test
    public void test()
    {
        List<List<Integer>>ans=largeGroupPositions( "abbxxxxzzy");
        System.out.println(ans.toString());

    }
}
