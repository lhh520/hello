package test;

import java.util.*;

public class Solution {
    /*private List<List<Integer>> ans;
    private List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        // 首先排序，让相同的两个元素排到一起去，便于去重
        Arrays.sort(nums);
        int n = nums.length;
        // 使用 visited 数组来记录哪一个元素在当前路径中被使用了
        boolean[] visited = new boolean[n];
        // 开始回溯
        backtrace(nums, 0, visited, n);
        return ans;
    }

    private void backtrace(int[] nums, int start, boolean[] visited, int n) {
        // 首先加入当前路径
        ans.add(new ArrayList<>(path));
        // 从 start 开始遍历每一个元素，尝试加入路径中
        for (int i = start; i < n; ++i) {
            // 如果当前元素和前一个元素相同，而且前一个元素没有被访问，说明前一个相同的元素在当前层已经被用过了
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            // 记录下来，用过了当前的元素
            visited[i] = true;
            path.add(nums[i]); // 放到路径中
            backtrace(nums, i + 1, visited, n); // 向下一个递归
            visited[i] = false; // 回溯
            path.remove(path.size() - 1);

        }
    }*/
    /*
    int[]ans;
    int[]re;
    public Solution(int[] nums) {
        ans=nums;
        re=nums.clone();
    }

    public int[] reset() {
      return re;
    }

    public int[] shuffle() {
       List<Integer>list=new ArrayList<>();
       for(int i=0;i<re.length;i++)
       {
           list.add(re[i]);
       }
        Collections.shuffle(list);
       int[]an=new int[re.length];
       for(int i=0;i<list.size();i++)
       {
           an[i]=list.get(i);
       }
       return an;
    }*/
    /*
    ListNode tt;
    public Solution(ListNode head) {
    tt=head;
    }

    public int getRandom() {
    ListNode cur=tt;
    int len=0;
    while (cur!=null)
    {
       len++;
       cur=cur.next;
    }
    //
        Random  r=new Random(1);
    int temp=r.nextInt(len);
    cur=tt;
    while (temp>0)
    {
        cur=cur.next;
        temp--;
    }
    return cur.val;
    }*/
    int[][]nums;
    int[][]re;
    int mm,nn;
    Random random=new Random();
    public Solution(int m, int n) {
        mm=m;
        nn=n;
        nums=new int[m][n];
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                nums[i][j]=0;
            }
        }
        re=nums.clone();
    }

    public int[] flip() {
        int flag=0;
        int x=0,y=0;
       while (flag==0)
       {
           x=random.nextInt(mm);
           y=random.nextInt(nn);
           if(nums[x][y]==0)
           {
               nums[x][y]=1;
               flag=1;
           }
       }
       return new int[]{x,y};
    }

    public void reset() {
        for (int i = 0; i <mm; i++) {
            for (int j = 0; j <nn; j++) {
                nums[i][j]=0;
            }
        }
    }
}
