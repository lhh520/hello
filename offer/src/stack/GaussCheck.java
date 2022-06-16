package stack;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kay on 2018/1/30.
 */
public class GaussCheck {

    private boolean isGauss;

    private StatisticConstant statisticConstant;

    public GaussCheck(boolean isGauss, StatisticConstant statisticConstant) {
        this.isGauss = isGauss;
        this.statisticConstant = statisticConstant;
    }

    public StatisticConstant getStatisticConstant() {
        return statisticConstant;
    }

    public void setStatisticConstant(StatisticConstant statisticConstant) {
        this.statisticConstant = statisticConstant;
    }


    public boolean isGauss() {
        return isGauss;
    }

    public void setGauss(boolean gauss) {
        isGauss = gauss;
    }


    public static GaussCheck KSTest(Double[] list) {

        if (list == null || list.length == 0) {
            return new GaussCheck(false, new StatisticConstant());
        }

        int length = list.length;     /// TODO 原始数组长度
        double median = 0.0D;   //中位数
        double upperQuartile = list[length * 3 / 4];  //上四分位
        double downQuartile = list[length  / 4];  //下四分位
        if (length % 2 == 0) {
            double midTemp = list[length / 2-1 ] + list[length / 2];
            median = midTemp / 2.0;
        } else {
            median = list[length / 2];
        }


        TreeMap<Double, Integer> map = new TreeMap<>();  ///有序map,key-原始值,value-频数

        double sum = 0.00;
        for (int i = 0; i < length; i++) {
            sum += list[i];                       //求和
            Integer count = map.get(list[i]);
            if (count != null && count != 0) {
                map.put(list[i], ++count);
            } else {
                map.put(list[i], 1);
            }
        }

        double avgNum = sum / length * 1.00;

        double s = 0.00;       // 差平方和
        for (int i = 0; i < length; i++) {
            double temp = (list[i] - avgNum) * (list[i] - avgNum);
            s = s + temp;
        }
        double var = s / (length - 1);       //方差
        double deviation = Math.sqrt(var);   //标准差

        double variation = deviation / avgNum;   //变异系数

        int mapSize = map.size();
        Double[] keyArray = map.keySet().toArray(new Double[]{});

        double maxNum = keyArray[mapSize - 1];  //最大值
        double minNum = keyArray[0];     //最小值
        double range = maxNum - minNum; //极差
        double modeNum = 0.0;

        Integer[] frequencyArr = map.values().toArray(new Integer[]{});   //频数数组

        map.clear();

        int frequencyArrLength = keyArray.length;
        double[] leijiArr = new double[frequencyArrLength];     //TODO  实际累计概率数组  Cumulative probability

        int modeIndex=0;
        for (int i = 0; i < frequencyArr.length; i++) {
            if (frequencyArr[modeIndex] < frequencyArr[i]) {
                modeIndex = i;
            }
            int temp = cumulativeFrequency(frequencyArr, i);     //累计频数
            double num = temp / (length * 1.00);  //累计频率
            leijiArr[i] = num;
        }
        modeNum = keyArray[modeIndex];

        double[] gaussArr = new double[frequencyArrLength];   //TODO 理论累计概率
        double maxDeviation = 0.00;  //理论值与实际值最大偏差

        for (int i = 0; i < frequencyArrLength; i++) {
            double b = (keyArray[i] - avgNum) / deviation;   //标准正态分布离差
            gaussArr[i] = gauss(b);    //理论概率密度

            double temp1 = Math.abs(gaussArr[i] - leijiArr[i]);
            if (maxDeviation < temp1) {
                maxDeviation = temp1;//这里下手
            }
        }

        double d = getD(length);
        boolean isGauss = checkGauss(d, maxDeviation);

        //统计常量
        StatisticConstant statisticConstant = new StatisticConstant(avgNum, median, modeNum, upperQuartile,
                downQuartile, var, deviation, variation, range, maxNum, minNum);

        return new GaussCheck(isGauss, statisticConstant);
    }


    public static Map drawData(Double u, Double sima) {
        Double t = u-3*sima;
        TreeMap<Double, Double> map = new TreeMap<>();
        //为了画出峰值，绘图区间为[u-3*sima,u+3*sima],步长为u/10
        for (; t < u+3*sima; t += u/10) {
            Double y = densityFunc(t, u, sima);
            map.put(t, y);
        }

        Double[] x = map.keySet().toArray(new Double[]{});
        Double[] y = map.values().toArray(new Double[]{});

        map.clear();

        Map dataMap = new HashMap();
        dataMap.put("x", x);   //横轴数组
        dataMap.put("y", y);    //纵轴数组


        return dataMap;
    }

    /**
     * 默认置信度：a=0.05
     *
     * @param d
     * @param maxDeviation
     * @return
     */
    private static boolean checkGauss(Double d, Double maxDeviation) {
        if (maxDeviation >= d)
            return false;          // 拒绝原假设  p< 0.05
        else
            return true;            //接受原假设   ---服从正态分布  p> 0.05

    }


    /**
     * 默认置信度：a=0.05
     *
     * @param n 样本数量
     * @return
     */
    private static double getD(Integer n) {
        if (n > 0 && n <= 5) {
            return 0.562;
        } else if (n > 5 && n <= 10) {
            return 0.409;
        } else if (n > 10 && n <= 20) {
            return 0.294;
        } else if (n > 20 && n <= 30) {
            return 0.242;
        } else if (n > 30 && n <= 50) {
            return 0.189;
        } else if (n > 50) {
            return 1.36 / Math.sqrt(n);
        }
        return -0.1;
    }

    /**
     * 正态分布概率密度
     *
     * @param b
     * @return
     */
    private static double gauss(Double b) {
        Double a = -10000D;
        Double sum = 0.00;
        Integer n = 10000;
        for (int i = 1; i < n; i++) {
            double t = temp(a, b, n, i);
            sum += f(t);
        }
        return (2 * sum + f(a) + f(b)) * (b - a) / (2 * n);    //梯形面积
    }

    /**
     * 区间的中间值
     *
     * @param a 下限
     * @param b 上限
     * @param n 等分大小
     * @param i 第几区间
     * @return
     */
    private static double temp(Double a, Double b, Integer n, Integer i) {
        return a + i * (b - a) / n;
//        return a + (2 * i - 1) * (b - a) /(2 * n);
    }

    /**
     * 正态分布被积函数
     *
     * @param t
     * @return
     */
    private static double f(double t) {
        return 1 / Math.sqrt(2 * Math.PI) * Math.exp(-t * t / 2);
    }

    /**
     * 正态分布概率密度函数
     *
     * @param x     因变量
     * @param u     均值（数学期望）
     * @param sigma 标准差
     * @return
     */
    private static double densityFunc(Double x, Double u, Double sigma) {
        return 1.0 / (Math.sqrt(2 * Math.PI) * sigma) * Math.exp(-(x - u) * (x - u) / (2 * sigma * sigma));
    }

    /**
     * 计算累计频数
     */
    private static int cumulativeFrequency(Integer[] arr, int n) {
        if (n == 0) return arr[0];
        else {
            return cumulativeFrequency(arr, n - 1) + arr[n];
        }
    }

    public static void main(String[] args) {
        Double[] list=new Double[]{
                -26.9155895896255D,
                23.131279956724D,
                14.8355025228375D,
                -3.3484172692988D,
                18.076142421487D,
                16.0152001424285D,
                3.18725031116628D,
                -26.3367144018411D,
                24.1486862048623D,
                24.6650745591614D,
                -4.70648612666992D,
                24.789752640354D,
                8.91525931161596D,
                12.0637207853724D,
                -8.57632469182136D,
                3.41213197112666D,
                2.25297756311193D,
                39.0965181193314D,
                17.0431588028441D,
                4.81745021512324D,
                9.09479811321943D,
                -2.40005985891912D,
                16.8641520556412D,
                -3.73510258417809D,
                8.87133526499383D,
                18.8807416886993D,
                -13.6366940953303D,
                13.2655873383192D,
                15.0578864829731D,
                22.3125664686086D,
                -8.08979050110793D,
                -5.70778294990305D,
                16.9007603542559D,
                -0.896355888689868D,
                8.95117298365221D,
                -0.779510830616346D,
                7.06490712014784D,
                36.1295463133137D,
                28.0323286258499D,
                -10.5694004762336D,
                14.06980234402D,
                26.2344281307014D,
                26.8029282576754D,
                17.7398988196364D,
                2.81361510838906D,
                2.5737029116135D,
                5.20497794947005D,
                -7.09845491859596D,
                -2.32504018844338D,
                -6.85116785665741D,
                1.14436832314823D,
                3.42682258429704D,
                -0.159194516745629D,
                24.9408265315287D,
                2.56550040627189D,
                19.2549089458771D,
                -2.6133249978011D,
                -8.2429039341514D,
                10.9759946806298D,
                6.10218424095365D
        };
        GaussCheck dd=GaussCheck.KSTest(list);
        StatisticConstant ss=dd.getStatisticConstant();
        double uu=ss.getMean();
        double sigma=ss.getDeviation();
        Map dataMap =dd.drawData(uu,sigma);//图形绘制
        System.out.println(dd.isGauss);
    }

}



