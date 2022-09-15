package LCP;

import java.util.*;

public class testududd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strs=str.split(" ");
        int n=Integer.parseInt(strs[0]);
        int m=Integer.parseInt(strs[1]);
        List<List<Integer>> uu=combine(n,m);
        int count=0;
        for(List<Integer>uuu:uu){
            if(lengthOfLIS(uuu)==3){
                count=(count+1)%998244353;
            }
        }
        System.out.println(count%998244353);
    }

    static List<List<Integer>> result = new ArrayList<>();
    static  LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k);
        return result;
    }
    private static void combineHelper(int n,int m){
        if (path.size() == n){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <=m; i++){
            path.add(i);
            combineHelper(n, m);
            path.removeLast();
        }
    }
    public static int lengthOfLIS(List<Integer>listss) {
        int[]nums=new int[listss.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=listss.get(i);
        }
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
