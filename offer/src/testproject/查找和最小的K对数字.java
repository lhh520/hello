package testproject;

import org.junit.Test;

import java.util.*;

public class 查找和最小的K对数字 {
    /*
    * 暴力法
    * */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                List<Integer>list=new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                lists.add(new ArrayList<>(list));
            }
        }
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)+o1.get(1)-(o2.get(0)+o2.get(1));
            }
        });
        if(lists.size()<k){
            return lists;
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(lists.get(i));
        }
        return ans;
    }


    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k){
        PriorityQueue<int[]>pq=new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]];
            }
        });
        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.offer(new int[]{i,0});
        }
        List<List<Integer>>ans=new ArrayList<>();
        while (k-->0&&!pq.isEmpty()){
            int[]pos=pq.poll();
            ans.add(Arrays.asList(nums1[pos[0]],nums2[pos[1]]));
            if(++pos[1]< nums2.length){
                pq.add(pos);
            }
        }
        return ans;
    }



    @Test
    public void test(){
        int[]nums1=new int[]{1,7,11};
        int[]nums2=new int[]{2,4,6};
        List<List<Integer>>list=kSmallestPairs1(nums1,nums2,3);
        System.out.println(list.toString());
    }
}
