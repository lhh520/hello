import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class test392 {
    public boolean isSubsequence(String s, String t)
    {
        boolean table[][]=new boolean[s.length()+1][t.length()+1];
        //先初始化第一行
        for(int col=0;col<table[0].length;col++)
        {
            table[0][col]=true;
        }
        for(int row=1;row<table.length;row++)
        {
            char ch1=s.charAt(row-1);
            for(int col=1;col<table[row].length;col++)
            {
                char ch2=t.charAt(col-1);
                if(ch1==ch2)
                    table[row][col]=table[row-1][col-1];
                else
                    table[row][col]=table[row][col-1];
            }
        }
        boolean[] lastRow=table[table.length-1];
        return lastRow[lastRow.length-1];//返回最后一行的最后一个数组
    }
    @Test
    public void test()
    {

    }
}
