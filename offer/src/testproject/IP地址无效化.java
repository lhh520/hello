package testproject;

import org.junit.Test;

import java.util.List;

public class IP地址无效化 {
    public String defangIPaddr(String address) {
        String  jj=address.replaceAll("\\.","\\[.\\]");
        System.out.println(address);
        return jj;
    }
    @Test
    public void test(){
       String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }
}
