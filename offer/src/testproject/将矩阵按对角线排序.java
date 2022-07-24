package testproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 将矩阵按对角线排序 {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        Map<Integer, List<Integer>>map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer>list=map.getOrDefault(i-j,new ArrayList<>());
                if(list.size()==0){
                    list.add(mat[i][j]);
                }else {
                    int k;
                    for(k=0;k<list.size();k++){
                        if(list.get(k)>mat[i][j]){
                            list.add(k,mat[i][j]);
                            break;
                        }
                    }
                    if(k==list.size()){
                        list.add(mat[i][j]);
                    }
                }
                map.put(i-j,list);
            }
        }
        //已经实现了排序
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer>list=map.get(i-j);
                mat[i][j]=list.get(0);
                list.remove(list.get(0));
            }
        }
        return mat;
    }
}
