package testproject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class testprocess {

    public  List<ProcessBean> listAllProcess() {
        List<ProcessBean>result=new ArrayList<>();
        Process exec=null;
        BufferedReader bufferedReader=null;
        try {
            //服务器中命令执行
            exec=Runtime.getRuntime().exec("ps -ef");
            //得到执行命令的返回
            InputStream inputStream=exec.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String buffer="";
            int line=0;
            while ((buffer=bufferedReader.readLine())!=null)
            {
                if(line!=0)
                    result.add(analysis(buffer));
                line+=1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    private static ProcessBean analysis(String row) {
        System.out.println(row);
        int pos = 0;
        int nextStartPos = 0;

        boolean isReadSpace = true;
        List<Object> result = new ArrayList<>();
        while (pos < row.length()) {
            char c = row.charAt(pos);
            //32是空格，遇到空格就添加nextStartPos, pos之间的字符，
            if (isReadSpace && c == 32) {
                result.add(row.substring(nextStartPos, pos));
                isReadSpace = false;
                nextStartPos = pos;
            }
            if (!isReadSpace && c != 32) {
                nextStartPos = pos;
                if (result.size() == 7) {
                    result.add(row.substring(nextStartPos, row.length()));
                    break;
                }
                isReadSpace = true;
            }
            pos++;
        }
        ProcessBean processBean = new ProcessBean(result.get(0).toString(),
                Integer.valueOf(result.get(1).toString()),
                Integer.valueOf(result.get(2).toString()),
                Integer.valueOf(result.get(3).toString()),
                result.get(4).toString(),
                result.get(5).toString(),
                result.get(6).toString(),
                result.get(7).toString());
        return processBean;

    }
    @Test
    public void test()
    {
        List<ProcessBean>result=listAllProcess();
        System.out.println(result.get(0).toString());
    }
}
