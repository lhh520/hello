package offertest1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class tesyyyy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[]yy=str.split(" ");
        int m=Integer.parseInt(yy[0]);
        int n=Integer.parseInt(yy[1]);
        int[][]mat=new int[n][2];
        for(int i=0;i<n;i++){
            String str1=in.nextLine();
            String[]yy1=str1.split(" ");
            int m1=Integer.parseInt(yy1[0]);
            int n1=Integer.parseInt(yy1[1]);
            mat[i][0]=m1;
            mat[i][1]=n1;
        }
//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(mat[i]));
//        }
        int[][]ans=merge(mat);
        int[]fi=new int[m+1];
        for(int []num:ans){
            int b=num[0],e=num[1];
            for(int j=b;j<=e;j++){
                fi[j]++;
            }
        }
        System.out.println(Arrays.toString(fi));
        for(int i=1;i<=m;i++){
            if(fi[i]<1){
                System.out.println("fail");
                return;
            }
        }
        System.out.println(n-ret);
        return;



    }
    static int ret=0;
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                if(R<=merged.get(merged.size() - 1)[1]+1){
                    ret++;
                }else {
                    merged.get(merged.size() - 1)[1]=R;
                }

            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
