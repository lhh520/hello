package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最大交换 {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }
        //System.out.println(Arrays.toString(last));
        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {//标号存在 并且在后面 则可以进行前后的交换
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    @Test
    public void test(){
        System.out.println(maximumSwap(2736));
    }
}
