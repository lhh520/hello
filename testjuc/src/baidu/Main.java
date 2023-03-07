package baidu;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = 0 , b = 0;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            if ( a < b ) {
                a += b / 2;
            }
            for (int j = 0; j < n; j++) {
                b++;
                a += b;
            }
            for (int j = 1; j < n; j *= 2) {
                b--;
            }
        }
        System.out.println(a);
    }
}
