package mei01;

import java.text.DecimalFormat;
import java.util.*;

public class test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        String[]in=nn.split(" ");
        int n=Integer.parseInt(in[0]);
        int m=Integer.parseInt(in[1]);
        double[][]cs=new double[n][2];
        int[][]map=new int[n][2];
        String nnn=sc.nextLine();
        String[]uu=nnn.split(" ");
        for(int i=0;i<n;i++){
            map[i][0]=Integer.parseInt(uu[i]);
        }
        String bbb=sc.nextLine();
        String[]uuuu=bbb.split(" ");
        //System.out.println(Arrays.toString(uuuu));
        for(int i=0;i<n;i++){
            map[i][1]=Integer.parseInt(uuuu[i]);
        }
        double ret=0;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            ret+=map[i][0]*map[i][1];
            int ccc=(100-map[i][0])*map[i][1];
            list.add(ccc);
        }

        Collections.sort(list);

        int sz=list.size()-1;
        while (m-->0){
            ret+=(list.get(sz--));
        }

        //System.out.println(ret*0.01);

        System.out.println(new DecimalFormat("00.00").format(ret*0.01));
//        Arrays.sort(map, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[1]-o1[1];
//            }
//        });
//        double sum=0;
//        if(m>=n){
//            m=n;
//        }
//        for(int i=0;i<n;i++){
//            if(m>0){
//                m--;
//                sum+=map[i][1];
//            }else {
//                sum+=map[i][0]*map[i][1]*0.01;
//            }
//
//        }
//        System.out.println(new DecimalFormat("00.00").format(sum));
    }
}
