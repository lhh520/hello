package LCP;

import java.util.*;

public class testdddd {
    static Map<Integer,List<Integer>>map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        int n=Integer.parseInt(str1);
        map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            String str2=sc.nextLine();
            String[]strings=str2.split(" ");
            int from=Integer.parseInt(strings[0]);
            int to=Integer.parseInt(strings[1]);
            List<Integer>list=map.getOrDefault(from,new ArrayList<>());
            list.add(to);
            map.put(from,new ArrayList<>(list));
        }
        int[]nums=new int[n+1];
        Arrays.fill(nums,1);
        Queue<Integer>queue=new LinkedList<>();
        queue.add(1);
        int count=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                int top=queue.poll();
                if(nums[top]!=top){
                    nums[top]++;
                    //dfs(nums,top);
                    count++;
                }
                List<Integer>list=map.getOrDefault(top,new ArrayList<>());
                for(int ii:list){
                    queue.add(ii);
                }
            }
        }
        System.out.println(count);
    }
    public void dfs(int[]nums,int top){
        if(!map.containsKey(top)){
            return;
        }
    }
}
