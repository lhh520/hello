package plan92.yyyy;

public class testyeyey {
    public long calculateTotal (int count) {
        // write code here
        if(count==0||count==1||count==2){
            return 1;
        }else {
            return calculateTotal(count-1)+calculateTotal(count-2);
        }

    }

}
