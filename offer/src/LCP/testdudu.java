package LCP;

import java.util.*;

public class testdudu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String str1=sc.nextLine();

        String[]strings=str1.split(" ");
        List<String>list=new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            list.add(strings[i]);
        }
        //System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o2.compareTo(o1);
                }else {
                    return o2.length()-o1.length();
                }
            }
        });

        List<String>list2=list.subList(0,3);
        //System.out.println(list2);
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list2.get(0)+list2.get(1)+list2.get(2));
    }
}
