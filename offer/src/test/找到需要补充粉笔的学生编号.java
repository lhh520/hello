package test;

import org.junit.Test;

import java.util.Arrays;

public class 找到需要补充粉笔的学生编号 {
    public int chalkReplacer(int[] chalk, int k) {
        long total= Arrays.stream(chalk).sum();//先求总和
        k%=total;
        for(int i=0;i<chalk.length;i++){
            k=k-chalk[i];
            if(k<0){
                return i;
            }
        }
        return -1;
    }
    public int chalkReplacer1(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;
        for (int num : chalk) {
            total += num;
        }
        k %= total;
        int res = -1;
        for (int i = 0; i < n; ++i) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }

    @Test
    public void test(){
        int[] chalk=new int[]{3,4,1,2};
        int k=25;
        System.out.println(chalkReplacer(chalk,k));
    }
}
