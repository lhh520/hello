package testproject;

import org.junit.Test;

public class 换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ret=numBottles;
        while (numBottles>numExchange-1){//一直到瓶子大于1
            //先计算空瓶能换的酒
            int no=numBottles/numExchange;
            ret+=no;
            numBottles=no+numBottles%numExchange;
        }
        return ret;
    }
    @Test
    public void test(){
        System.out.println(numWaterBottles(15,4));
    }
}
