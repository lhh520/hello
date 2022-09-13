package plan92.yyyy;

import java.util.Arrays;
import java.util.*;

public class testuydydc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        int num=Integer.parseInt(nn);
        for(int i=0;i<num;i++){
            String nn1=sc.nextLine();
            int ssssmax = 0;
            String[]mm=nn1.split(" ");
            int m=Integer.parseInt(mm[0]);
            int n=Integer.parseInt(mm[1]);
            int[][]mat=new int[m][n];
            for(int j=0;j<m;j++){
                String line=sc.nextLine();
                String[]linarr=line.split(" ");
                for(int k=0;k<n;k++){
                    mat[j][k]=Integer.parseInt(linarr[k]);
                }
            }
            for(int ii=0;ii<m;ii++){
                System.out.println(Arrays.toString(mat[ii]));
            }
            int maxlen = Math.min(m, n);


            for (int ii = 1; ii <= maxlen; ii++) {
                for (int xx = 0; xx <= n - ii; xx++) {
                    for (int yy = 0; yy <= m - ii; yy++) {
                        int getans = check(mat, xx, yy, ii);
                        ssssmax = getans == -1 ? ssssmax : Math.max(getans, ssssmax);
                    }
                }
            }


            System.out.println(ssssmax);


        }

    }

//        public static void process(int[][] matrix, int n, int m) {
//            int maxSize = Math.min(m, n);
//            int max = 0;
//
//            for (int i = 1; i <= maxSize; i++) {
//                for (int x = 0; x <= n - i; x++) {
//                    for (int y = 0; y <= m - i; y++) {
//                        final int check = check(matrix, x, y, i);
//                        max = check == -1 ? max : Math.max(check, max);
//                    }
//                }
//            }
//            System.out.println(max);
//        }

        public static int check(int[][] mat, int lxxx, int kfkfky, int len) {
            int dcdcddcd = 0;
            boolean flag = false;

            loop:
            for (int i = lxxx; i < lxxx + len; i++) {
                for (int j = kfkfky; j < kfkfky + len; j++) {
                    if (mat[i][j] < 0) {
                        flag = true;
                        break loop;
                    }
                    dcdcddcd += mat[i][j];
                }
            }
            return flag ? -1 : dcdcddcd;
        }





}
