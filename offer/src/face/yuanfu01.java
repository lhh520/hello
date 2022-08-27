package face;

import org.junit.Test;

import java.util.*;

public class yuanfu01 {
    /*2
12 A tidy tiger tied a tie tighter to tidy her tiny tail
1 a
16 A big black bug bit a big black bear made the big black bear bleed blood
2 b?? b???
    * */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String M=sc.nextLine();
        int m=Integer.parseInt(M);

        for(int i=0;i<m;i++){
            int max=0;
            Map<String,Integer>map=new HashMap<>();
            String first=sc.nextLine();
            String[]fi=first.split(" ");
            int num1=Integer.parseInt(fi[0]);
            String second=sc.nextLine();
            String[]se=second.split(" ");
            int num2=Integer.parseInt(se[0]);
            for(int j=1;j<=num1;j++){
                boolean flag=true;
                String cur=fi[j].toLowerCase(Locale.ROOT);
                for(int k=1;k<=num2;k++){
                    String ss=se[k].toLowerCase(Locale.ROOT);
                    if(ss.contains("?")){
                        int end=ss.indexOf('?');
                        String prev=ss.substring(0,end);
                        if(cur.startsWith(prev)&&cur.length()==ss.length()){
                            flag=false;
                            break;
                        }
                    }else {
                        if(cur.compareTo(ss)==0){
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag){
                    String numa=fi[j].toLowerCase(Locale.ROOT);
                    map.put(numa,map.getOrDefault(numa,0)+1);
                    max=Math.max(max,map.get(numa));
                }

            }
            System.out.println(max);
        }

    }

}
