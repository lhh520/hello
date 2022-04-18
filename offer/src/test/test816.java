package test;

import java.util.ArrayList;
import java.util.List;

public class test816 {

    public List<String> ambiguousCoordinates(String s) {
       List<String>ans=new ArrayList<>();
       for(int i=0;i<s.length()-1;i++){
           //遍历，添加逗号
           for(String left:make(s,1,i)){
               for(String right:make(s,i,s.length()-1))
                   ans.add("("+left+","+right+")");
           }
       }
       return ans;
    }
    //遍历 添加.
    public List<String>make(String s,int i,int j){
      List<String>ans=new ArrayList<>();
      for(int d=1;d<=j-i;++d){
          String left=s.substring(i,i+d);//向左边添加点
          String right=s.substring(i+d,j);//向右边添加点
          if((!left.startsWith("0")||left.equals("0"))&&!right.endsWith("0"))
              ans.add(left+(d<j-i?".":"")+right);
      }
      return ans;
    }
}
