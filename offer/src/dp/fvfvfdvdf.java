package dp;

import java.util.*;

public class fvfvfdvdf {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s1=str.split(" ");
        int n=Integer.parseInt(s1[0]),i=Integer.parseInt(s1[1]);
        String str1=sc.nextLine();
        String[] s2=str1.split(" ");
        List<Integer>list=new ArrayList<>();
        for(int j=0;j<s2.length;j++){
            if(j==i){
                list.add(i);
            }
            list.add(Integer.parseInt(s2[j]));
        }
        if(list.size()==n){
            list.add(i);
        }
        for (int j = 0; j <list.size(); j++) {
            System.out.print(list.get(j));
            if(j!=list.size()){
                System.out.print(" ");
            }
        }

    }
}
