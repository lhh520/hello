package test;

public class 平分正方形 {
    public double[] cutSquares(int[] square1, int[] square2) {
        //第一个正方形的中心点，x,y坐标及正方形边长
        double x1 = square1[0] + square1[2]/2.0;
        double y1 = square1[1] + square1[2]/2.0;
        int d1 = square1[2];
        //第二个正方形的中心点，x,y坐标及正方形边长
        double x2 = square2[0] + square2[2]/2.0;
        double y2 = square2[1] + square2[2]/2.0;
        int d2 = square2[2];
        //结果集
        double[] res = new double[4];
        //两个中心坐标在同一条x轴上，此时两条直线的斜率都是无穷大
        if(x1 == x2){
            res[0] = x1;
            res[1] = Math.min(square1[1], square2[1]);
            res[2] = x1;
            res[3] = Math.max(square1[1] + d1, square2[1] + d2);
        }else{
            //斜率存在，则计算斜率和系数，y = kx + b;
            double k = (y1 - y2)/(x1 - x2);//斜率计算公式
            double b = y1 - k*x1;
            //斜率绝对值大于1，说明与正方形的上边和下边相交
            if(Math.abs(k) > 1){
                //先计算底边，也就是两个正方形左下坐标y的最小值
                res[1] = Math.min(square1[1],square2[1]);
                res[0] = (res[1] - b)/k;
                //再计算顶边，也就是两个正方形左下坐标y+边长的最大值
                res[3] = Math.max(square1[1] + d1,square2[1] + d2);
                res[2] = (res[3] - b)/k;
            }else{
                //斜率绝对值小于等于1，说明与正方形的左边和右边相交，同理
                res[0] = Math.min(square1[0],square2[0]);
                res[1] = res[0]*k + b;
                res[2] = Math.max(square1[0] + d1,square2[0] + d2);
                res[3] = res[2]*k + b;
            }
        }
        //题目要求x1 < x2,如果结果不满足，我们交换两个点的坐标即可
        if(res[0] > res[2]){
            swap(res, 0 ,2);
            swap(res, 1, 3);
        }
        return res;
    }
    public void swap(double[] res, int x, int y){
        double temp = res[x];
        res[x] = res[y];
        res[y] = temp;
    }
}
