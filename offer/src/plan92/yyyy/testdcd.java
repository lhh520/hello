package plan92.yyyy;

import org.junit.Test;

import java.util.*;

public class testdcd {
    public int[] findBuilding (int[] heights) {
        Stack<Integer>stack1=new Stack<>(),stack2=new Stack<>();
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        int n=heights.length;
        for(int i=0,j=n-1;i<n&&j>=0;i++,j--){
            list1.add(stack1.size());
            list2.add(stack2.size());
            while (!stack1.isEmpty()&&stack1.peek()<=heights[i]){
                stack1.pop();
            }
            while (!stack2.isEmpty()&&stack2.peek()<=heights[j]){
                stack2.pop();
            }
            stack1.push(heights[i]);
            stack2.push(heights[j]);
        }
        //Collections.reverse(list1);
        Collections.reverse(list2);
        int[]ret=new int[n];
        for(int i=0;i<n;i++){
            ret[i]=list1.get(i)+list2.get(i)+1;
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{50, 30, 80, 30, 27, 57};
        int[]num=findBuilding(nums);
        System.out.println(Arrays.toString(num));
    }
}
