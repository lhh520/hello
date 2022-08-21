package mei01;

import java.util.Map;
import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        int n=Integer.parseInt(nn);
        int[][]map=new int[3][2];
        String n1=sc.nextLine();
        String[]u1=n1.split(" ");
        map[0][0]=Integer.parseInt(u1[0]);
        map[0][1]=Integer.parseInt(u1[1]);

        String n2=sc.nextLine();
        String[]u2=n2.split(" ");
        map[1][0]=Integer.parseInt(u2[0]);
        map[1][1]=Integer.parseInt(u2[1]);

        String n3=sc.nextLine();
        String[]u3=n3.split(" ");
        map[2][0]=Integer.parseInt(u3[0]);
        map[2][1]=Integer.parseInt(u3[1]);
        String n4=sc.nextLine();
        String[]u4=n4.split(" ");
        int[]tar=new int[3];
        tar[0]=Integer.parseInt(u4[0]);
        tar[1]=Integer.parseInt(u4[1]);
        tar[2]=Integer.parseInt(u4[2]);
        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
                int c1=Math.abs(map[0][0]-i)+Math.abs(map[0][1]-j);
                int c2=Math.abs(map[1][0]-i)+Math.abs(map[1][1]-j);
                int c3=Math.abs(map[2][0]-i)+Math.abs(map[2][1]-j);
                if(c1==tar[0]&&c2==tar[1]&&c3==tar[2]){
                    System.out.println(""+i+" "+j);
                    return;
                }
            }
        }
    }

}
