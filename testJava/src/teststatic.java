public class teststatic {
    private static int a=5;
    public static void main(String[] args) {
        teststatic t=new teststatic();
        t.a++;
        System.out.println(t.a);
        teststatic tt=new teststatic();
        tt.a++;
        System.out.println(tt.a);
        teststatic.a--;
        System.out.println(teststatic.a);
    }
    
}
