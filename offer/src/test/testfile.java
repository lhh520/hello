package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testfile {


    public static void main(String[] args) {
        String path="/Users/lihehui";
        File file=new File(path);
        boolean f=file.isDirectory();
        List<File>list= Arrays.asList(file.listFiles());

        System.out.println(list.toString());
    }
}
