package testproject;

public class 最长回文串 {
    public static void main(String[] args) {
        for(int i=1;i<=143;i++){
            if(i<10){
                System.out.println("000"+i+".png"+";"+"000"+i+"_GT.png");
            }
            if(i>=10&&i<100){
                System.out.println("00"+i+".png"+";"+"00"+i+"_GT.png");
            }
            if(i>=100){
                System.out.println("0"+i+".png"+";"+"0"+i+"_GT.png");
            }
        }

    }
}
