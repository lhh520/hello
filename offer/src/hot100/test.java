package hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int[][]arrays=new int[5][2];
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
    }
}
