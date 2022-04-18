package offer;

import java.util.*;

public class offer084 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    Set<List<Integer>>set=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums)
    {
    for(int i=0;i<nums.length;i++)
    {
        list.add(nums[i]);
    }
    dfs(list,0);
    return lists;
    }
    public void dfs(List<Integer>list,int i)
    {
        if(i>=list.size()&&set.add(new ArrayList<>(list)))
            lists.add(new ArrayList<>(list));
        for(int j=i;j<list.size();j++)
        {

            Collections.swap(list,j,i);
            dfs(list,i+1);
            Collections.swap(list,j,i);

        }
    }

}
