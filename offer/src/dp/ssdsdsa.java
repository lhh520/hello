package dp;
import java.util.*;
public class ssdsdsa {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public static boolean judgePoint24(double[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (double num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public static boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nn=Integer.parseInt(input.nextLine());
        int count=0;
        for(int i=0;i<nn;i++){

            //System.out.println("请输入4个数： ");
            double[] arr = new double[5];


            String str=input.nextLine();

            String[]ss=str.split(" ");
            if(ss.length==4){
                for(int x=0;x<ss.length;x++)
                    arr[x] = Double.parseDouble(ss[x]);
                    arr[4]=1;
            }else {
                for(int x=0;x<ss.length;x++)
                    arr[x] = Double.parseDouble(ss[x]);
            }


            boolean flag=judgePoint24(arr);

            if(flag)
            {
                count++;
                //System.out.println(true);
            }
            else {
                //System.out.println(false);
            }
            //System.out.println("计算完毕！");
        }
        System.out.println(count);
    }
}

