package test;

import org.junit.Test;

import java.util.*;

public class 婴儿名字 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String,String>map1=new HashMap<>();
        HashMap<String,Integer>map2=new HashMap<>();
        for(int i=0;i<synonyms.length;i++){
            String[] st=synonyms[i].split(",");
            String n1=st[0].substring(1);
            String n2=st[1].substring(0,st[1].length()-1);
            //存入字典序比较大的数字
            if(n1.compareTo(n2)>0){
                map1.put(n1,n2);
                map2.put(n2,0);
            }else {
                map1.put(n2,n1);
                map2.put(n1,0);
            }
        }
        //开始遍历名
        for(int i=0;i<names.length;i++){
            String[]temp=names[i].split("\\(");
            String name=temp[0];
            String count=temp[1].substring(0,temp[1].length()-1);
            int co=Integer.parseInt(count);
            //先判定是复杂的还是简单的 简单的直接相加
            if(map2.containsKey(name)){//表示为简单的
                map2.put(name,map2.get(name)+co);
            }else {
                String tt=map1.get(name);//获取到简单的
                map2.put(tt,map2.get(tt)+co);
            }
        }
        String[]ans=new String[map2.size()];
        int k=0;
        for(Map.Entry<String,Integer>entry: map2.entrySet()){
            //System.out.println(entry.getKey()+":  "+" "+entry.getValue());
            ans[k]=entry.getKey()+"("+entry.getValue()+")";
            k++;
        }
        return ans;
    }
    //并查集
    public String[] trulyMostPopular1(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();     //并查集， key(子孙)->value(祖宗)
        for (String name : names) {     //统计频率
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.valueOf(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms) {  //union同义词
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)) {   //找name1祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {   //找name2祖宗
                name2 = unionMap.get(name2);
            }
            if(!name1.equals(name2)){   //祖宗不同，要合并
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);    //出现次数是两者之和
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                map.remove(nickName);       //更新一下数据
                map.put(trulyName, frequency);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(map.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }

    @Test
    public void test(){
        String[]names =new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms =new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[]nn=trulyMostPopular(names,synonyms);
        System.out.println(Arrays.toString(nn));
    }
}
