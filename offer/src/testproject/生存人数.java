package testproject;

public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        int start=1900,end=2000;
        int[]num=new int[end-start+2];
        for(int i=0;i<birth.length;i++){
            num[birth[i]-1900]++;
            num[death[i]-1900+1]--;
        }
        int max=0,sum=0,res=0;
        for(int i=0;i<end-start+1;i++){
            sum+=num[i];
            if(sum>max){
                max=sum;
                res=i;
            }

        }
        return start+res;
    }
}
