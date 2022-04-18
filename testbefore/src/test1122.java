import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

public class test1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<arr1.length;i++)
        {
            map.put(arr1[i],map.getOrDefault(map.get(arr1[i]),0)+1);
        }
        int[] ans=new int[arr1.length];
        int cur=0;
        for(int i=0;i<arr2.length;i++)
        {
             int fre=map.get(arr2[i]);

             for(int j=0;j<fre;j++)
             {
                 ans[cur+j]=arr2[i];
             }
             cur=cur+fre;
             set.add(arr2[i]);
        }
        System.out.println(cur);
        int[]res=new int[arr1.length-cur];
        int jj=0;
        for(int i=0;i<arr1.length;i++)
        {

            if(!set.contains(arr1[i]))
            {
                res[jj]=arr1[i];
                jj++;
                //System.out.println(res[jj]);
            }
        }
        Arrays.sort(res);
        for(int i=cur;i<arr1.length;i++){
            ans[i] = res[i-cur];
        }
        return ans;

    }
    @Test
    public void test()
    {
        int[]arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[]arr2 = new int[]{2,1,4,3,9,6};
        int[]ans=relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }
}
