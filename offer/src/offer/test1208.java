package offer;

public class test1208 {
    public int equalSubstring(String s, String t, int maxCost) {
       int n=s.length();
       int[] diff=new int[n];//用来记录对应数字之间的差值
       for(int i=0;i<n;i++)
       {
           diff[i]=Math.abs(s.charAt(i)-t.charAt(i));
       }
       int maxLength=0;
       int start=0,end=0;
       int sum=0;
       while (end<n)
       {
           sum+=diff[end];//将所有的差值进行相加
           //如果总和大于最大的差值，则左边界应该向右移动
           while (sum>maxCost)
           {
               sum=sum-diff[start];//左指针右移动
               start++;
           }
           maxLength=Math.max(maxLength,end-start+1);
           end++;//右指针右移动
       }
       return maxLength;
    }
}
