package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer>ret=new ArrayList<>();
        int row=1,rowStart=1;
        while (rowStart*2<label){
            row++;
            rowStart*=2;
        }
        if(row%2==0){
            label=getReverse(label,row);
        }
        while (row>0){
            if(row%2==0){
                ret.add(getReverse(label,row));
            }else {
                ret.add(label);
            }
            row--;
            label>>=1;
        }
        Collections.reverse(ret);
        return ret;
    }
    public int getReverse(int label,int row){
        return (1<<row-1)+(1<<row)-1-label;
    }
    @Test
    public void test(){
        int label = 4;
        System.out.println(pathInZigZagTree(label));
    }
}
