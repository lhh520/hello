package backtrace;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class ReadTxtFile {
    public static void Txt(String filepath){
        String encoding = "gbk";//txt一般默认编码为gbk
        File file = new File(filepath);
        if(file.exists() && file.isFile()){
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);

                String txtLine = "";
                int i=0;
                while((txtLine = bufferedReader.readLine()) != null){
                    if(txtLine.contains("epoch")){
                        if(i==50)
                            System.out.println(" ");
                        String[]line=txtLine.split(",");
                        int len=line[2].length();
                        System.out.print(line[2].substring(len-6,len)+",");
                        i++;
                    }

                    //System.out.println(txtLine);
                }
                read.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        }
    public static void main(String[] args) {
        String filepath = "/Users/lihehui/IdeaProjects/hello/offer/src/backtrace/lhh2.txt";
        Txt(filepath);
    }
}
