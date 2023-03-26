package labuladong;

import org.junit.Test;

public class qunaer01 {
    //4296,1601,4757
    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        int num=1;
        for(int i=0;i<decryption;i++){
            num=((encryptedNumber%number)*(num%number))%number;
        }
        return num;
    }
    @Test
    public void test(){
        int num=Decrypt(4296,1601,4757);
        System.out.println(num);
    }
}
