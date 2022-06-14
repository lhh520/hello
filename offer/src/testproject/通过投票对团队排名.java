package testproject;

import org.junit.Test;

import java.util.*;

public class 通过投票对团队排名 {
    public String rankTeams(String[] votes) {
        int len= votes.length;
        Map<Character,int[]>map=new HashMap<>();
        List<Character>list=new ArrayList<>();
        for(int i=0;i<votes.length;i++){
            for(int j=0;j<votes[i].length();j++){
                if(!map.containsKey(votes[i].charAt(j))){
                    map.put(votes[i].charAt(j),new int[votes[i].length()]);
                }
                int[]temp=map.get(votes[i].charAt(j));
                temp[j]++;//表示当前位加1
            }
        }
        for(Character c:map.keySet()){
            list.add(c);
        }
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int[]arr1=map.get(o1);
                int[]arr2=map.get(o2);
                int i=0,j=0;
                while (i<arr1.length&&arr1[i]==arr2[j]){
                    i++;
                    j++;
                }
                if(i==j&&i==arr1.length){
                    return o1-o2;
                }else {
                    return arr2[j]-arr1[i];
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String[]strs=new String[]{"WXYZ","XYZW"};
        String hh=rankTeams(strs);
        System.out.println(hh);
    }
}
