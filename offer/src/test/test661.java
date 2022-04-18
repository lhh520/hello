package test;

import org.junit.Test;

import java.util.*;

public class test661 {
    int[]dx=new int[]{-1,0,1,-1,1,-1,0,1};
    int[]dy=new int[]{-1,-1,-1,0,0,1,1,1};
    public int[][] imageSmoother(int[][] img)
    {   int n=img.length;
        int m=img[0].length;
        int[][]newimage=new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                int count=1;
                int sum=img[i][j];
                for(int k=0;k<8;k++)
                {
                    int mx=i+dx[k];
                    int my=j+dy[k];
                    if(mx>=0&&mx<n&&my>=0&&my<m)
                    {
                        count++;
                        sum=sum+img[mx][my];
                    }

                }
                newimage[i][j]=sum/count;
            }
        }
        return newimage;
    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int[]help=arr.clone();
        HashMap<Integer,Integer>order=new HashMap<>();
        for (int i = 0; i < help.length; i++) {
            order.put(help[i],i);
        }
    Arrays.sort(arr);
    HashMap<List<Integer>,Integer>map=new HashMap<>();
    int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            List<Integer>list=new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i+1]);
            map.put(new ArrayList<>(list),arr[i]-arr[i-1]);
            min=Math.min(min,arr[i]-arr[i-1]);
        }
        List<List<Integer>>lists=new ArrayList<>();
        for(Map.Entry<List<Integer>,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==min)
            {
                lists.add(new ArrayList<>(entry.getKey()));
            }
        }
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                //return 0;
                int n1=order.get(o1.get(0));
                int n2=order.get(o2.get(0));
                return n2-n1;
            }
        });
        return lists;
    }
    /*public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] nn= arr.clone();
        Arrays.sort(nn);
        //System.out.println(Arrays.toString(nn));
        //System.out.println(Arrays.toString(arr));
        int k=1;
        for (int i = 0; i <nn.length; i++) {
            if(!map.containsKey(nn[i]))
            {
                map.put(nn[i],k);
                k++;
                //System.out.println(nn[i]+"  "+k);
            }
        }
        int[]ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }*/
    @Test
    public void test()
    {

    }
}
