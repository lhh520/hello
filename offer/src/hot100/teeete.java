package hot100;

public class teeete {
    public boolean isValid (String str) {
        // write code here
        String[]strs=str.split("-");
        if(strs.length!=3){
            return false;
        }
        for(int i=0;i< strs.length;i++){
            String ss=strs[i];
            for(int j=0;j<ss.length();j++){
                if(ss.charAt(j)<'0'&&ss.charAt(j)>'9'){
                    return false;
                }
            }
        }
        return true;
    }
}
