package plan92.线程;

import java.util.*;

public class testddd {



    public static int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            p[i + 1] = t;
        }
        System.out.println(Arrays.toString(p));
        long res = 0;
        for (int i = 1, j = 2, k = 2; i < n - 1 && p[i] * 3 <= p[n]; i++) {
            int left = p[i];
            // 两个分割点必须保持前后顺序
            j = Math.max(i + 1, j);
            while (j < n - 1 && p[j] - p[i] < left) j++;
            while (k < n - 1 && p[k + 1] - p[i] <= p[n] - p[k + 1]) k++;
            res += k - j + 1;
        }
        return (int) res;
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strings=str.split(" ");
        int[]nums=new int[strings.length];
        int n= strings.length;;
        for(int i=0;i<strings.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
        }
        int[] pre = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            pre[i]=pre[i-1]+nums[i-1];
        }
        //System.out.println(Arrays.toString(pre));
        long ans = 0;
        for (int i = 1, j = 2, k = 2; i < n - 1 && pre[i] * 3 <= pre[n]; i++) {
            int left = pre[i];
            j = Math.max(i + 1, j);
            while (j < n - 1 && pre[j] - pre[i] < left) j++;
            while (k < n - 1 && pre[k + 1] - pre[i] <= pre[n] - pre[k + 1]) k++;
            ans += k - j + 1;
        }


        System.out.println(ans);
    }
}
