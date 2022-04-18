import org.junit.Test;

public class test38 {
    public String countAndSay(int n) {
    //初始化一个字符串
    String str="1";
    //从下一个字符开始遍历
    for(int i=2;i<=n;i++)
    {   //统计每一个字符出现的次数
        int start=0;
        int pos=start;
        StringBuilder sb=new StringBuilder();
        //当区间没有到达最右边的时候，如果之间的数字相等，则又边界向后移动，增加1
        while (pos<str.length())
        {
            while (pos<str.length()&&str.charAt(pos)==str.charAt(start))
                pos++;
        //将字符重复的次数和字符输入进去
        sb.append(Integer.toString(pos-start)).append(str.charAt(start));
        //将开始节点移动到后面，当前的数字结束
        start=pos;}
        //生成下一次的新的字符串
        str=sb.toString();
    }
    return str;
    }
    @Test
    public void test()
    {
        int n=4;
        System.out.println(countAndSay(4));
    }
}
