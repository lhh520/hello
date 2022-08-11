package 代码随想录二刷.回溯;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums){
        int curdiff=0;
        int prediff=0;
        int res=1;
        for(int i=0;i<nums.length;i++){
            if((curdiff>0&&prediff<=0)||(curdiff<0&&prediff>=0)){
                res++;
                prediff=curdiff;//更新最新的值
            }
        }
        return res;
    }
    public int wiggleMaxLength1(int[] nums){

    }
}
