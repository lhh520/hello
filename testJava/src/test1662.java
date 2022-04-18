import org.junit.Test;

public class test1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for (int i = 0; i <word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i <word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }
    @Test
    public void test()
    {
        String[] a=new String[]{"ab", "c"};
        String[] b=new String[]{"a", "bc"};
        System.out.println(arrayStringsAreEqual(a,b));

    }
}
