package stack;

import java.util.Stack;

public class test42 {
    public int trap(int[] height) {
        int sz=height.length;
        int[]lheight=new int[sz];
        int[]rheight=new int[sz];
        int sum=0;
        for(int i=0;i<sz;i++){
            if(i==1||i==sz-1) continue;
            int rh=height[i];
            int lh=height[i];
            for(int r=i+1;r<sz;r++){
                if(height[r]>rh){
                    rh=height[r];
                }
            }
            for(int l=i-1;l>=0;l--){
                if(height[l]>lh){
                    lh=height[l];
                }
            }
            int h=Math.min(lh,rh)-height[i];
            if(h>0) sum=sum+h;
        }
        return sum;
    }
    public int trap1(int[] height){
        int sum=0;
        int size=height.length;
        if(size<=2) return 0;
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        for(int index=1;index<size;index++){
            int stacktop=stack.peek();
            if(height[index]<stacktop){
                stack.push(index);
            }else if(height[index]==height[stacktop]){
                stack.pop();
                stack.push(index);
            }else {
                int heightAtidex=height[index];
                while (!stack.isEmpty()&&(heightAtidex>height[stacktop])){
                    int mid=stack.pop();
                    if(!stack.isEmpty()){
                        int left=stack.peek();
                        int h=Math.min(height[left],height[index]-height[mid]);
                        int w=index-left-1;
                        int hold=h*w;
                        if(hold>0) sum+=hold;
                        stacktop=stack.peek();
                    }
                }
                stack.push(index);
            }
        }
        return sum;
    }
}
