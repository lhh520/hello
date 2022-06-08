package testproject;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 员工的重要性 {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee>queue=new LinkedList<>();
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).id==id){
                queue.add(employees.get(i));
                break;
            }
        }
        int ans=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                Employee ee=queue.poll();
                ans=ans+ee.importance;
                if(ee.subordinates.size()!=0){
                    for(int j=0;j<ee.subordinates.size();j++){
                        for(int k=0;k<employees.size();k++){
                            if(employees.get(k).id==ee.subordinates.get(j)){
                                queue.add(employees.get(k));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
