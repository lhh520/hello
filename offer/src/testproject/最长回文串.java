package testproject;

public class 最长回文串 {
    public static void main(String[] args) {
        for(int i=1;i<=204;i++){
            if(i<52){
                System.out.println("1_"+i+"_cut.jpg"+" "+"0");
            }
            if(i>=52&&i<96){
                System.out.println("2_"+(i-51)+"_cut.jpg"+" "+"1");
            }
            if(i>=96&&i<174){
                System.out.println("3_"+(i-95)+"_cut.jpg"+" "+"2");
            }
            if(i>=174&&i<198){
                System.out.println("4_"+(i-173)+"_cut.jpg"+" "+"3");
            }
            if(i>198){
                System.out.println("5_"+(i-198)+"_cut.jpg"+" "+"4");
            }

        }

    }
}
