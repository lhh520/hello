package LCP;

import java.util.*;

public class testdydy {
    static Map<String,Boolean>map=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(str.length()==0){
            System.out.println(0);
            return;
        }
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String strs=str.substring(i,j+1);
                if(check1(strs)){
                    //System.out.println(strs);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean check(String str){
         if(map.containsKey(str)){
             return map.get(str);
         }
         Map<Character,Integer>map1=new HashMap<>();
         for(int i=0;i<str.length();i++){
             map1.put(str.charAt(i),map1.getOrDefault(str.charAt(i),0)+1);
         }
         int a=0,b=0;
         for(Map.Entry<Character,Integer>entry:map1.entrySet()){

            if(entry.getValue()%2!=0){
                 a++;
            }else {
                b++;
            }
         }
         if(a==1){
             map.put(str,true);
             return true;
         }else {
             map.put(str,false);
             return false;
         }
    }
    public static boolean check1(String str){
        if(map.containsKey(str)){
            return map.get(str);
        }
        Map<Character,Integer>map1=new HashMap<>();
        int[]nums=new int[26];
        for(int i=0;i<str.length();i++){
            nums[str.charAt(i)-'a']++;

        }
        int a=0,b=0;
        for(int i=0;i<26;i++){

            if(nums[i]%2!=0){
                a++;
            }else {
                b++;
            }
        }
        if(a==1){
            map.put(str,true);
            return true;
        }else {
            map.put(str,false);
            return false;
        }
    }
}
