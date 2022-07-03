package testproject;

public class Pauta{    //创建拉依达类
    private double arr[];         //接受原始数组
    public Pauta(double temp[]) { //利用构造方法来得的原始数组
        this.arr=temp;
        System.out.print("原始数组：");
        for(double x:arr) {
            System.out.print(x+"、");
        }
        System.out.println();
    }
    public double average() {    //原始数组的算数平均值方法
        double sum=0;
        for(int x=0;x<arr.length;x++) {
            sum+=arr[x];
        }
        return sum/arr.length;

    }
    public double[] residualError() {//原始数组的剩余误差方法
        double rE[]=new double[] {};
        for(int x=0;x<arr.length;x++) {
            rE[x]=arr[x]-average();
        }
        return rE;
    }
    public double standardVariance() {//原始数组的标准方差值计算方法
        double sum=0;
        for(int x=0;x<arr.length;x++) {
            sum+=Math.pow(arr[x]-average(),2);
        }
        return Math.sqrt(sum/(arr.length-1));

    }
    public void judge() {              //判断异常值方法，若异常，则输出
        for(int x=0;x<arr.length;x++) {
            if(Math.abs(arr[x]-average())>(3*standardVariance())) {
                System.out.println("该数组中的第"+(x+1)+"个元素属于异常值");
            }
        }
    }

    public static void main(String[] args) {
        double data[]=new double[] {2,3,4,6,5,6,7,7,8,8,0,100};//原始数组
        Pauta pau=new Pauta(data);//原始数组封装后输出
        System.out.println("算数平均值："+pau.average());//算数平均值
        /*此处的剩余误差输出略*/
        System.out.println("标准方差："+pau.standardVariance());//标准方差
        pau.judge();//判断异常值方法

    }
}

