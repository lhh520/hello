package Hash;
import java.util.*;
public class testrrs {
    static Map<Integer,List<Integer>>m=new HashMap<>();
    static long res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n-1;i++){
            int x=sc.nextInt(),y=sc.nextInt();
            builderTree(x,y);
            builderTree(y,x);
        }
        dfs(1,new boolean[n+1],1);
        System.out.println(res);
    }
    private static void dfs(int root,boolean[]flag,int parent){
        flag[root]=true;
        List<Integer>list=m.get(root);
        res+=root-parent;
        for(Integer integer:list){
            if(flag[integer]) continue;
            dfs(integer,flag,root);
        }
    }
    private static void builderTree(int x,int y){
        List<Integer>list=m.get(x);
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(y);
        m.put(x,list);
    }
}
