package face;

public class face0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
    return generateBTS(nums,0,nums.length-1);
    }
    public TreeNode generateBTS(int[] nums,int start,int end)
    {
        if(start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=generateBTS(nums,start,mid-1);
        root.right=generateBTS(nums,mid+1,end);
        return root;
    }
}
