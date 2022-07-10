package 热题100;

import org.junit.Test;

import java.util.Locale;

public class 将标题首字母大写 {
    public String capitalizeTitle(String title) {
        String[]strs=title.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<=2){
                sb.append(strs[i].toLowerCase());
            }else {
                char c=strs[i].charAt(0);
                if(c>='a'&&c<='z'){
                    c=(char)(c-32);
                    sb.append(c);
                    sb.append(strs[i].substring(1).toLowerCase());
                }else {
                    sb.append(c);
                    sb.append(strs[i].substring(1).toLowerCase());
                }
            }

            if(i!=strs.length-1){
                sb.append(" ");
            }
        }


        return sb.toString();
    }
    @Test
    public void test(){
        String title = "capiTalIze tHe titLe";
        System.out.println(capitalizeTitle(title));
    }
}
