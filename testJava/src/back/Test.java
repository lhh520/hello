package back;

public class Test{
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;//x=-1
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;//y=1 x=1
        System.out.println(y);
    }
}
