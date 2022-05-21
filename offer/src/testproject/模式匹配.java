package testproject;
/*未解决*/
public class 模式匹配 {
    public boolean patternMatching(String pattern, String value) {
        String s[]=new String[2];
        return solve(s,pattern,0,value,0);
    }
    /**
     * 回溯遍历设置a,b的对应值，尝试每一种可能。
     * @param s   s[0]=a对应的字符串 s[1]=b对应的字符串
     * @param pattern 模式串
     * @param index1 模式串匹配位置
     * @param value 匹配串（待匹配的字符串）
     * @param index2 匹配串匹配位置
     * @return
     */
    public boolean solve(String []s,String pattern,int index1,String value,int index2){
        //匹配完成
        if(index1==pattern.length()&&index2==value.length()) return true;
        //注意匹配串匹配位置等于长度的时候也可以继续匹配，因为模式串的a，b可以匹配空串。
        if(index1>=pattern.length()||index2>value.length()) return false;
        int num=pattern.charAt(index1)-'a';
        if(s[num]==null){
            //从当前尝试a或b对应的字符串的每一种可能
            for(int i=index2;i<=value.length();i++){
                s[num]=value.substring(index2,i);
                //(!s[num].equals(s[num^1]))  [是指a，b对应的字符串不可相等]
                if(!s[num].equals(s[num^1])&&solve(s,pattern,index1+1,value,i)) return true;
            }
            //失配时应将设置过的对应字符串为空
            s[num]=null;
            return false;
        }else{
            //若此前a或b已有对应的字符串匹配了，则查看当前位置时候能够匹配上。
            int end=index2+s[num].length();
            if(end> value.length()||!value.substring(index2,end).equals(s[num])) return false;
            return solve(s,pattern,index1+1,value,end);
        }
    }

    int aCount;
    int bCount;

    public boolean patternMatching1(String pattern, String value) {
        int patLen = pattern.length();
        int valLen = value.length();
        //1 pattern为""
        if (patLen == 0) {
            return valLen == 0;
        }
        //记录pattern中a,b的数量
        for (int i = 0; i < patLen; i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }
        //2 pattern不为""
        //2.1 value为"",判断pattern是否为一种字符组成
        if (valLen == 0) {
            return aCount == 0 || bCount == 0;
        }
        //2.2.1 value不为"",处理pattern只有一种字符串的情况，只有一种字符
        if (aCount == 0) {
            return helper(value, bCount);
        } else if (bCount == 0) {
            return helper(value, aCount);
        }
        //2.2.2 value不为"",处理pattern中'a'或'b'可为""的情况
        if (helper(value, aCount)) {
            return true;
        }
        if (helper(value, bCount)) {
            return true;
        }
        //2.2.3 value不为"",枚举'a','b'所代表的字符串长度，以长度进行枚举
        //使得aCount*aLen+bCount*bLen=valLen
        for (int aLen = 1; aLen * aCount <= valLen - bCount; aLen++) {
            //valLen减去所有a代表的字符串,个数不够为bCount的倍数
            if ((valLen - aLen * aCount) % bCount != 0) {//不满足都整除的情况
                continue;
            }
            //通过aLen计算bLen
            int bLen = (valLen - aLen * aCount) / bCount;
            if (check(pattern, value, aLen, bLen)) {
                return true;
            }
        }
        return false;
    }

    boolean helper(String val, int k) {//将val k等份
        int len = val.length();
        if (len % k != 0) {
            return false;
        }
        int perStrLen = len / k;
        for (int i = perStrLen; i < len; i += perStrLen) {
            if (!val.substring(i, i + perStrLen).equals(val.substring(0, perStrLen))) {
                return false;
            }
        }
        return true;
    }

    boolean check(String pattern, String value, int aLen, int bLen) {
        String a = null;
        String b = null;
        for (int i = 0, j = 0; i < pattern.length(); i++) {
            //j每次移动aLen或bLen的长度
            if (pattern.charAt(i) == 'a') {
                if (a == null) {
                    a = value.substring(j, j + aLen);//选择的标准字符串
                } else if (!value.substring(j, j + aLen).equals(a)) {
                    return false;
                }
                j += aLen;
            } else {
                if (b == null) {
                    b = value.substring(j, j + bLen);
                } else if (!value.substring(j, j + bLen).equals(b)){
                    return false;
                }
                j += bLen;
            }
        }
        return true;
    }
}
