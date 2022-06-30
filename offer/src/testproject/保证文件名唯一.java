package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 保证文件名唯一 {
    public String[] getFolderNames(String[] names) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<names.length;i++){
            if(!set.contains(names[i])){
                set.add(names[i]);
            }else {//已经包含了

                int j=0;
                while (true){
                    StringBuilder sb=new StringBuilder();
                    sb.append(names[i]);
                    String  gg="("+(++j)+")";
                    sb.append(gg);
                    if(!set.contains(sb.toString())){
                        names[i]=sb.toString();
                        set.add(names[i]);
                        break;
                    }

                }
            }
        }
        return names;
    }
    @Test
    public void test(){
        String[]names =new String[]{"wano","wano","wano","wano"};
        String[]name=getFolderNames(names);
        System.out.println(Arrays.toString(name));
    }
}
