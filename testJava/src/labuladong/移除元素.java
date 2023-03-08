package labuladong;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int leftIndex=0;
        int rightIndex=nums.length-1;
        while (leftIndex<=rightIndex){//left指向左边第一个是当前元素的数字，right指向右边不是第一个元素
            while (leftIndex<=rightIndex&&nums[leftIndex]!=val){//这时指向左边第一个为
                leftIndex++;
            }
            //找到右边第一个不等于val的元素
            while (leftIndex<=rightIndex&&nums[rightIndex]==val){
                rightIndex--;
            }
            //将两者进行交换
            if(leftIndex<rightIndex){
                nums[leftIndex++]=nums[rightIndex--];
            }
        }
        return leftIndex;
    }
}
