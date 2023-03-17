package back;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class didi01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[]ss=s.split(" ");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        int p=Integer.parseInt(ss[2]);
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n-1;i++){
            list.add(i);
        }
        int[]candidates=new int[list.size()];
        for(int i=0;i<candidates.length;i++){
            candidates[i]=list.get(i);
        }
        List<List<Integer>>res=combinationSum(candidates,n,m,p);
        if(res.size()==0){
            System.out.println(-1);
            System.exit(0);
        }
        List<Integer>list1=res.get(0);
        //System.out.println(list1.toString());
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i));
            if(i!=list1.size()-1){
                System.out.print(" ");
            }
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target,int m,int p) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0,m,p);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx,int m,int p) {
        if (sum == target&&path.size()==m&&getSum(path)==p) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i,m,p);
            path.remove(path.size() - 1);
        }
    }
    public static int getSum(List<Integer> path){
        int sum=0;
        for(int i=0;i<path.size();i++){
            sum+=path.get(i)*path.get(i);
        }
        return sum;
    }
}
