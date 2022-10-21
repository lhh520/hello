package LCP;

public class dhdhd {
    private int s;
    public static void main(String[] args) {
        dhdhd p=new dhdhd();
        p.s=2;
        dhdhd q=new dhdhd();
        q.s=1;

        swap(p,q);
        System.out.println(p.s);
        System.out.println(q.s);
    }
    public static void swap(dhdhd p,dhdhd q){
        dhdhd temp=p;
        p=q;
        q=temp;
        System.out.println(p.s);
        System.out.println(q.s);
    }
}
