package tp101.链表;

import java.util.*;

public class test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        int n=Integer.parseInt(nn);
        List<String> ret=new ArrayList<>();
        for(int i=0;i<n;i++){
            String m1=sc.nextLine();
            String m2=sc.nextLine();
            Set<Character> set=new HashSet<>();
            StringBuilder sb=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            if(m1.length()>m2.length()){
                ret.add("NO");
                continue;
            }

            for(int ii=0;ii<m1.length();ii++){
                 if(sb.length()==0||m1.charAt(ii)!=sb.charAt(sb.length()-1)){
                     sb.append(m1.charAt(ii));
                 }
            }
            for(int ii=0;ii<m2.length();ii++){
                if(sb2.length()==0||m2.charAt(ii)!=sb2.charAt(sb2.length()-1)){
                    sb2.append(m2.charAt(ii));
                }
            }




            if(sb.toString().compareTo(sb2.toString())!=0){
                ret.add("NO");
                //System.out.println("NO");
            }else {
                ret.add("YES");
                //System.out.println("YES");
            }

        }
        for(int i=0;i<n;i++){
            System.out.println(ret.get(i));
        }
    }
}
