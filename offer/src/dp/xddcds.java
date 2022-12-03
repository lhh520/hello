package dp;

import java.util.*;

public class xddcds {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strings=str.split(" ");
        int n=Integer.parseInt(strings[0]);
        int k=Integer.parseInt(strings[1]);
        String str1=sc.nextLine();
        String[]strings1=str1.split(" ");
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<strings1.length;i++){
            if (set.add(Integer.parseInt(strings1[i]))){
                list.add(Integer.parseInt(strings1[i]));
            }
        }
        Collections.sort(list);
        if(list.size()-k<0){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(list.size()-k));
    }
}
