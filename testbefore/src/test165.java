import org.junit.Test;

public class test165
{   //比较版本号
    public int compareVersion(String version1, String version2) {
    String[] str1=version1.split("\\.");
    String[] str2=version2.split("\\.");
    for(int i=0;i<str1.length||i<str2.length;i++)
    {
        int s1=0,s2=0;
        if(i<str1.length)
            s1=Integer.parseInt(str1[i]);
        if(i<str2.length)
            s2=Integer.parseInt(str2[i]);
        if(s1<s2)
            return -1;
        if(s1>s2)
            return 1;
    }
    return 0;
    }
    public int compareVersion1(String version1, String version2)
    {
         String[] str1=version1.split("\\.");
         String[] str2=version2.split("\\.");
        System.out.println("hh");
         for(int i=0;i<str1.length||i<str2.length;i++)
         {
             int s1=i>=str1.length?0:Integer.parseInt(str1[i]);
             int s2=i>=str2.length?0:Integer.parseInt(str2[i]);
             if(s1<s2)
                 return -1;
             if(s1>s2)
                 return 1;
             //else continue;
         }

         return  0;

    }
    @Test
    public void test()
    {   //"1.0.1"
        //"1"
        String version1 = "1.0.1", version2 = "1";
        int a= compareVersion1(version1,version2);
        System.out.println(a);
    }
}
