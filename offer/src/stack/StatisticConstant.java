package stack;



public class StatisticConstant{


    private double mean;	//平均值

    private double median; //中位数

    private double mode;  //众数

    private double upperQuartile;  //上四分位数

    private double downQuartile;   //下四分位数

    private double var;    //方差

    private double deviation;  //标准差

    private double variation;  //变异系数

    private double range;  //极差

    private double max;   //最大值

    private double min;     //最小值

//    private double skewness; //偏度
//
//    private double kurtosis; //峰度

    public StatisticConstant() {
    }

    public StatisticConstant(double mean, double median, double mode, double upperQuartile, double downQuartile, double var, double deviation, double variation, double range, double max, double min) {
        this.mean = mean;
        this.median = median;
        this.mode = mode;
        this.upperQuartile = upperQuartile;
        this.downQuartile = downQuartile;
        this.var = var;
        this.deviation = deviation;
        this.variation = variation;
        this.range = range;
        this.max = max;
        this.min = min;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getUpperQuartile() {
        return upperQuartile;
    }

    public void setUpperQuartile(double upperQuartile) {
        this.upperQuartile = upperQuartile;
    }

    public double getDownQuartile() {
        return downQuartile;
    }

    public void setDownQuartile(double downQuartile) {
        this.downQuartile = downQuartile;
    }

    public double getVar() {
        return var;
    }

    public void setVar(double var) {
        this.var = var;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

}



