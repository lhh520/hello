package dp;
import  java.util.*;
public class toutqj {
    static boolean flag=false;
    static ArrayList<double[]> allSorts;//定义排序表
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nn=Integer.parseInt(input.nextLine());
        int count=0;
        for(int i=0;i<nn;i++){
            flag=false;
            allSorts = new ArrayList<double[]>();
            //System.out.println("请输入4个数： ");
            double[] arr = new double[5];


            String str=input.nextLine();

            String[]ss=str.split(" ");
            if(ss.length==4){
                for(int x=0;x<ss.length;x++)
                arr[x] = Double.parseDouble(ss[x]);
                arr[4]=1;
            }else {
                for(int x=0;x<ss.length;x++)
                    arr[x] = Double.parseDouble(ss[x]);
            }



            permutation(arr, 0, arr.length - 1);	//将给定的4个数字的所有排序数组存到allSorts里


            //System.out.println(allSorts.toString());
            for(double[] a:allSorts)						//将排序表里面的每个排序数组进行递归查找
            {
                yy(a,"");										//查找到符合的情况就会打印出解法步骤
            }
            if(flag)
            {
                count++;
                //System.out.println(true);
            }
            else {
                //System.out.println(false);
            }
            //System.out.println("计算完毕！");
        }
        System.out.println(count);



    }

    public static void permutation(double[] nums, int start, int end) {
        if (start == end) { // 当只要求对数组中一个数字进行全排列时，只要就按该数组输出即可
            double[] newNums = new double[nums.length]; // 为新的排列创建一个数组容器
            for (int i=0; i<=end; i++) {
                newNums[i] = nums[i];
            }
            if(!isExist(allSorts,newNums))	//如果排序表中没有此排序，则添加进入
                allSorts.add(newNums); // 将新的排列组合存放起来
        }
        else {
            for (int i=start; i<=end; i++) {
                double temp = nums[start]; // 交换数组第一个元素与后续的元素
                nums[start] = nums[i];
                nums[i] = temp;
                permutation(nums, start + 1, end); // 后续元素递归全排列
                nums[i] = nums[start]; // 将交换后的数组还原
                nums[start] = temp;
            }
        }
    }
    //判断存入排序表的排序数组是否已在排序表中已存在
    public static boolean isExist(ArrayList<double[]> allSorts,double[] nums){
        boolean flag = false;
        for(double[] a:allSorts)
        {
            if(Arrays.toString(a).equals(Arrays.toString(nums))) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    //主体递归方法
    public static void yy(double[] arr,String info)	//arr为传入数组，info记录步骤信息
    {
        if(arr.length==1&&arr[0]==24) 	//如果数组的长度是1并且还是24时，代表是解
        {//System.out.println(info);
            flag=true;
        }	//输出算法步骤
        else if(arr.length==1)
            return;										//如果数组的长度是1但不是24，则返回
        else {
            int x = (int)arr[0],y = (int)arr[1];
            yy(getAdd(arr),info+x+"+"+y+"="+(x+y)+" ");
            yy(getMinus(arr),info+x+"-"+y+"="+(x-y)+" ");
            yy(getMultip(arr),info+x+"*"+y+"="+(x*y)+" ");
            yy(getDivision(arr),info+x+"/"+y+"="+(x/y)+" ");
        }
    }

    //返回一个数组，长度比传入时少1，temp为数组的第一个元素
    //比如传入move(3,[1,2,3,4])，那么返回数组[3.3.4]
    static double[] move(double temp,double arr[])
    {
        double [] arr1 = new double[arr.length-1];
        arr1[0] = temp;
        for(int x=1;x<arr1.length;x++)
            arr1[x] = arr[x+1];
        return arr1;
    }

    static double[] getAdd(double num[])
    {
        return move(num[0] + num[1],num);
    }
    static double[] getMinus(double num[])
    {
        return move(num[0] - num[1],num);
    }
    static double[] getMultip(double num[])
    {
        return move(num[0] * num[1],num);
    }
    static double[] getDivision(double num[])
    {
        return move(num[0] / num[1],num);
    }
}