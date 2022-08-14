package 代码随想录二刷.贪心;

public class 单调递增的数字 {
    public int monotoneIncreasingDigits(int n) {
        String[]strings=(n+"").split("");
        int start=strings.length;
        for(int i=start-1;i>0;i--){
            if(Integer.parseInt(strings[i])<Integer.parseInt(strings[i-1])){
                strings[i-1]=(Integer.parseInt(strings[i-1]))-1+"";
                start=i;
            }
        }
        for(int i=start;i<strings.length;i++){
            strings[i]="9";
        }
        return Integer.parseInt(String.join("",strings));
    }

}
