package back;



import java.util.ArrayList;
import java.util.List;

/*
 把一个长度为n的数组分成m份的所有情况(n>=m)
 本质上是将m-1个分隔符插在n-1个不同的位置
 */
public class Test{
    static ArrayList<Integer> path = new ArrayList<>();
    static ArrayList<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        insert(0,n-1,m-1);
        System.out.println(ans);
    }
    // 这里jindu用来记录前面分好的部分，res_n表示剩下的可以插的位置数，res_m表示剩下的分隔符数量。
    static void insert(int jindu,int res_n,int res_m){
        if(res_m==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(res_n < res_m) {
            return;
        }else if(res_m==res_n) {
            for (int i = 0; i <res_m; i++) {
                path.add(jindu+i+1);
            }
            ans.add(new ArrayList<>(path));
        }else{
            for (int i = 0; i <res_n; i++) {
                path.add(jindu+i+1);
                insert(jindu+i+1,res_n-i-1,res_m-1);
                path.remove(path.size()-1);
            }
        }
    }
}