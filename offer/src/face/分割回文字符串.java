package face;
import java.util.*;
public class 分割回文字符串 {
    List<String>list=new ArrayList<>();
    List<List<String>>lists=new ArrayList<>();
    String ss;
    public String[][] partition(String s){
        ss=s;
        char[] cc=s.toCharArray();
        backtrace(cc,0);
        int sz=lists.size();
        String[][]ans=new String[sz][];
        for(int i=0;i<sz;i++){
            List<String>kk=lists.get(i);
            String[]temp=new String[kk.size()];
            for(int j=0;j<kk.size();j++){
                temp[j]=lists.get(i).get(j);
            }
            ans[i]=temp;
        }
        return ans;
    }
    public void backtrace(char[]cc,int index){
        if(index==cc.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<cc.length;i++){
            if(check(cc,index,i)){
                list.add(ss.substring(index,i+1));
            }else {
                continue;
            }
            backtrace(cc,i+1);
            list.remove(list.size()-1);
        }

    }
    public boolean check(char[]cc,int i,int j){
        while (i<j){
            if(cc[i]!=cc[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
