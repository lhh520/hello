package plan92.yyyy;

public class test9898 {
//    public int Decrypt (int encryptedNumber, int decryption, int number) {
//        return (int) (Math.pow(encryptedNumber,decryption)%number);
//    }
    //

    public int Decrypt (int encryptedNumber, int decryption, int number) {

        int ans=1;
        encryptedNumber=encryptedNumber%number;
        for (int i=1;i<=decryption;i++){
            ans=(ans*encryptedNumber)%number;
        }
        return ans%number;
    }
    public static void pow(int x,int n){

    }
}
