package test;

import org.junit.Test;

import java.util.*;

public class 收藏清单 {
    /*favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],
    ["google","facebook"],["google"],["amazon"]]
    * */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        //进行了排序
        for(List<String>kk:favoriteCompanies){
            Collections.sort(kk);
        }
        List<Integer>ans=new ArrayList<>();
        //排序之后进行遍历
        for(int i=0;i<favoriteCompanies.size();i++){//第一层，找当前节点的父节点
            boolean sub=false;
            for(int j=0;j<favoriteCompanies.size();j++){
                if(i==j){//表示当前相等 不可能是当前节点的父节点
                    continue;
                }
                //比当前的节点的长度短  不可能是父节点
                if(favoriteCompanies.get(j).size()<favoriteCompanies.get(i).size()){
                    continue;
                }
                int max=favoriteCompanies.get(j).size()-favoriteCompanies.get(i).size();
                //进行判定
                sub=isSub(favoriteCompanies.get(i),favoriteCompanies.get(j),max);
            }
            if(!sub){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean isSub(List<String> child,List<String> parent, int space){
        int i = 0;
        //3. 按顺序比较字符串，父串可比子串多 父串长-子串长
        for(int j = 0; j < parent.size()&&i<child.size(); j++){
            if(parent.get(j).equals(child.get(i))){
                ++i;
            }else if(space>0){
                --space;
            }else{
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        //int[][]favoriteCompanies =new int[][]{{"leetcode","google","facebook"},{"google","microsoft"],["google","facebook"],["google"],["amazon"]]
        List<String>list1=new ArrayList<>();
        List<String>list2=new ArrayList<>();
        list1.add("leetcode");
        list1.add("google");
        list1.add("facebook");
        //
        list2.add("leetcode");
        list2.add("google");
        //System.out.println(isSub(list2,list1));
    }
}
