package tp101.链表;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nn=sc.nextLine();
        int n=Integer.parseInt(nn);
        List<String>ret=new ArrayList<>();
        for(int i=0;i<n;i++){
            String m1=sc.nextLine();
            String m2=sc.nextLine();
            Set<Character>set=new HashSet<>();
            for(int ii=0;ii<m1.length();ii++){
                set.add(m1.charAt(ii));
            }
            boolean flag=true;
            if(m2.length()<m1.length()){
                flag=false;
            }else {
                if(!m2.startsWith(m1)){
                    flag=false;
                }else {
                    for(int ii=m1.length()-1;ii<m2.length();ii++){
                        if(!set.contains(m2.charAt(ii))){
                            flag=false;
                            break;
                        }
                    }
                }

            }
            set.clear();
            if(!flag){
                //ret.add("NO");
                System.out.println("NO");
            }else {
                //ret.add("YES");
                System.out.println("YES");
            }

        }
//        for(int i=0;i<n;i++){
//            System.out.println(ret.get(i));
//        }
    }
}
