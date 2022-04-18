package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test869 {
    List<Character>list=new ArrayList<>();
    List<List<Character>>lists=new ArrayList<>();
    public boolean reorderedPowerOf2(int n) {
        //1.利用回溯算法得到所有的数字排序组合
        char[]chars=Integer.toString(n).toCharArray();
        //2.全排列问题
        dfs(chars,0,chars.length-1);
        //3.进行判断
        for(List<Character>ll:lists)
        {
            if(check(ll))
            {
                //System.out.println(ll.toString());
                return true;}
        }
        return false;
    }
    public void dfs(char[] chars,int index,int end)
    {
        if(index==end)
        {   //list.add(chars);
            for(int i=0;i<chars.length;i++)
            {
                list.add(chars[i]);
            }
            //System.out.println(list.toString());
            lists.add(new ArrayList<Character>(list));
            list.clear();
        }
        else
            for(int i=index;i<=end;i++)
            {
                swap(chars,index,i);
                dfs(chars,index+1,end);
                swap(chars,index,i);
            }
        //list.remove(list.size()-1);
    }
    public void swap(char[] chars,int i,int j)
    {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
    public boolean check(List<Character>ll)
    {
        if(ll.get(0)=='0')
            return false;
        int sum=0;
        for(int i=0;i<ll.size();i++)
        {
            int temp=ll.get(i)-'0';
            sum=sum*10+temp;
        }
        return (sum& (sum - 1))==0;
    }
    @Test
    public void test()
    {
        int n=24;
        System.out.println(reorderedPowerOf2(n));
    }
}
