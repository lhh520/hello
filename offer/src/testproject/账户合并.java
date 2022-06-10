package testproject;

import java.util.*;

public class 账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer>emailtoIndex=new HashMap<>();
        Map<String,String>emailtoName=new HashMap<>();
        int emailCount=0;
        //将邮箱进行编号
        for(List<String>account:accounts){
            String name=account.get(0);
            int size=account.size();
            for(int i=1;i<size;i++){
                String email=account.get(i);
                if(!emailtoIndex.containsKey(email)){
                    emailtoIndex.put(email,emailCount++);
                    emailtoName.put(email,name);
                }
            }
        }
        //
        Unionfind uf=new Unionfind(emailCount);
        for(List<String>account:accounts){
            String first=account.get(1);
            int firstIndex=emailtoIndex.get(first);
            int sz=account.size();
            for(int i=2;i<sz;i++){
                String nextEmail=account.get(i);
                int nextIndex=emailtoIndex.get(nextEmail);
                //将所有的邮箱进行了合并
                uf.union(firstIndex,nextIndex);
            }
        }
        //已经获取到了所有的
        Map<Integer,List<String>>indexToemails=new HashMap<>();
        for(String email: emailtoIndex.keySet()){
            int index=uf.find(emailtoIndex.get(email));
            List<String>account=indexToemails.getOrDefault(index,new ArrayList<String>());
            account.add(email);
            indexToemails.put(index,account);
        }




        //这时 将出现相同的邮箱的集合已经划归到一起去了
        List<List<String>>merged=new ArrayList<>();
        for(List<String>emails: indexToemails.values()){
            Collections.sort(emails);
            String name=emailtoName.get(emails.get(0));
            List<String>account=new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}
class Unionfind{
    int[]parent;
    public Unionfind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public void union(int index1,int index2){
        int index1_parent=find(index1);
        int index2_parent=find(index2);
        parent[index2]=index1;
    }
    public int find(int index){
        if(index==parent[index]){
            return index;
        }else {
            return find(parent[index]);
        }
    }
}
