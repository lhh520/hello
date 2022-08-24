package face;

public class test1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        int j=0;
        for(int i=0;i<nums1.length&&j<nums2.length;i++,j=Math.max(j,i)){
            while (j<nums2.length&&nums1[i]<=nums2[j]){
                j++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}
