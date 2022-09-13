package plan92.yyyy;
import java.util.*;
public class testcdchdcbhd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<int[]>list=new ArrayList<>();
        //String next=in.nextLine();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String next=in.nextLine();
            if(next==null||next.isEmpty()){
                break;
            }
            String[]strs=next.split(",");
           int[]nums=new int[strs.length];
           for(int i=0;i<strs.length;i++){
               nums[i]=Integer.parseInt(strs[i]);
           }
           // System.out.println(Arrays.toString(nums));
            list.add(nums);
            //next=in.nextLine();
        }
        //System.out.println(list);
        int[][]mat=new int[list.size()][list.get(0).length];
        for(int i=0;i<mat.length;i++){
            mat[i]=list.get(i);
        }
        System.out.println(maxAreaOfIsland(mat));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public static int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }
}
