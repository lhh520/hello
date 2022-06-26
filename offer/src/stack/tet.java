package stack;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class tet {
    @Test
    public void test(){

        try {

            File file = new File("/Users/lihehui/IdeaProjects/hello/offer/src/stack/yy.txt");

            FileInputStream readIn = new FileInputStream(file);

            InputStreamReader read = new InputStreamReader(readIn, "utf-8");

            BufferedReader bufferedReader = new BufferedReader(read);

            String oneLine= null;

            while((oneLine= bufferedReader.readLine()) != null){

                String[]bu=oneLine.split("	");
                StringBuilder sb=new StringBuilder();
                sb.append("insert into score value");
                sb.append("(");
                for(int i=0;i<bu.length;i++){
                    if(i==2){
                        sb.append("\'");
                        sb.append(bu[i]);
                        sb.append("\'");
                        sb.append(",");
                        continue;
                    }
                    sb.append(bu[i]);
                    if(i!=bu.length-1)
                        sb.append(",");
                }

                sb.append(");");

                System.out.println(sb.toString());

            }

            read.close();

        } catch (Exception e) {

            System.out.println("读取文件内容出错");

            e.printStackTrace();

        }

    }



//        //"1	1	Patton	1	3	2	5	3	2	2	6	2	2	8	6	6	4	2	2	2	6	8	1	7	2	5	2	5	2	2	1	2"
//       String ss= "1	1	Patton	1	3	2	5	3	2	2	6	2	2	8	6	6	4	2	2	2	6	8	1	7	2	5	2	5	2	2	1	2";
//       String[]bu=ss.split("	");
//       StringBuilder sb=new StringBuilder();
//       sb.append("(");
//       for(int i=0;i<bu.length;i++){
//           if(i==2){
//               sb.append("\'");
//               sb.append(bu[i]);
//               sb.append("\'");
//               sb.append(",");
//               continue;
//           }
//           sb.append(bu[i]);
//           if(i!=bu.length-1)
//           sb.append(",");
//       }
//
//        sb.append(")");
//        System.out.println(sb.toString());

}
