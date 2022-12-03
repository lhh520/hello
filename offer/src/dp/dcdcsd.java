package dp;
import java.util.*;
public class dcdcsd {
    static Set<String>set=new HashSet<>();
    static int a=0;
    static int kk;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strings=str.split(" ");
        int n=Integer.parseInt(strings[0]);
        int k=Integer.parseInt(strings[1]);
        kk=k;
        String str1=sc.nextLine();
        String[]strings1=str1.split(" ");
        List<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        int[]nums=new int[strings1.length];
        for(int i=0;i<strings1.length;i++){
           nums[i]=Integer.parseInt(strings1[i]);
        }
        //System.out.println(Arrays.toString(nums));
        List<List<Integer>>lists=combinationSum(nums,0);
        System.out.println(lists.size());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, 0);
        return res;
    }

    public static  void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int idx) {
        // 找到了数字和为 target 的组合
        if (path.size()==3&&set.add(path.toString())) {
            int sum=0;
            for(int ii:path){
                sum+=ii;
            }
            if(sum%kk==0)
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(res, path, candidates, i+1);
            path.remove(path.size() - 1);
        }
    }
}