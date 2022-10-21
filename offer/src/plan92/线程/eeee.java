package plan92.线程;

import java.util.*;

public class eeee {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        List<String>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int m=Integer.parseInt(sc.nextLine());
            List<String>list1=new ArrayList<>();
            for(int j=0;j<m;j++){
                String ss=sc.nextLine();
                list1.add(ss);
            }
            boolean flag=true;
            for(int p=0;p<list1.size();p++){
                String sss=list1.get(p);
                for(int q=0;q<list1.size();q++){
                    if(q!=p){
                        String sss1=list1.get(q);
                        if(sss.startsWith(sss1)||sss1.startsWith(sss)){

                            flag=false;
                        }
                    }

                }
            }
            if(flag){
                list.add("YES");
            }else {
                list.add("NO");
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
