package dp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("小明",2500.0));
        employees.add(new Employee("小军",8000.0));
        employees.add(new Employee("小红",100000.0));
        for(Employee emp:employees){
            System.out.println(emp.getName()+"应该缴纳的个人所得税是："+String.format("%.1f",gets(emp.getSalary())));
        }

    }

    public static double gets(double s){
        double t=s-3500;
        if(t<=0){
            //小于0，不需要扣税
            return 0.0;
        }
        //其它情况，按所给公式及表中数据计算
        else if(t>0&&t<=1500){
            return t*0.03-0;
        }
        else if(t>1500&&t<=4500){
            return t*0.10-105;
        }
        else if(t>4500&&t<=9000){
            return t*0.20-555;
        }
        else if(t>9000&&t<=35000){
            return t*0.25-1005;
        }
        else if(t>35000&&t<=55000){
            return t*0.30-2755;
        }
        else if(t>55000&&t<=80000){
            return t*0.35-5505;
        }
        else{
            return t*0.45-13505;
        }
    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
