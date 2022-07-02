package testproject;

public class 检查数组对是否可以被k整除 {
    public boolean canArrange(int[] arr, int k) {
        int[]mod=new int[k];
        for(int i=0;i<arr.length;i++){
            int cur=((arr[i]%k)+k)%k;
            mod[cur]++;
        }
        for(int i=0;i<=k/2;i++){
            if(k%2==0&&i==k/2){
                if(mod[i]%2!=0){
                    return false;
                }
                break;
            }
            if(mod[i]!=mod[k-i]){
                return false;
            }
        }
        return mod[0]%2==0;
    }
}
