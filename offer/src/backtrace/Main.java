package backtrace;

import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Main {

    /**
     * 任务步骤类
     * 【无需改动】
     */
    static class Step {
        //步骤id
        Long stepId;
        //步骤类型
        Long type;
        //动作 commit正向提交 cancel逆向撤销
        String action;

        public Step() {
        }

        public Long getStepId() {
            return stepId;
        }

        public void setStepId(Long stepId) {
            this.stepId = stepId;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return "Step{" +
                    "stepId=" + stepId +
                    ", type=" + type +
                    ", action='" + action + '\'' +
                    '}';
        }
    }

    /**
     * 将输入的字符串任务步骤转换为步骤类的对象
     *【无需改动】
     *
     * @param stepStr
     * @return
     */
    private static Step convertToStep(String stepStr) {
        String cleanStep = stepStr.substring(1, stepStr.length() - 1);
        String[] vars = cleanStep.split(",");
        String[] stepIdStr = vars[0].split(":");
        String[] typeStr = vars[1].split(":");
        String[] actionStr = vars[2].split(":");
        Step step = new Step();
        step.setStepId(Long.parseLong(stepIdStr[1]));
        step.setType(Long.parseLong(typeStr[1]));
        step.setAction(actionStr[1]);
        return step;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Step> strArr = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            strArr.add(convertToStep(in.nextLine()));
        }
        //题目逻辑计算
        long[] res = commitTask(strArr);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }

    /**
     * 任务缓存提交
     * 【实现此函数】
     *  代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param steps 任务缓存中的步骤列表
     * @return 最后真正提交的数据步骤id数组
     */
    public static long[] commitTask(List<Step> steps) {
        //todo 请实现此函数
        Map<Long,Step>map=new HashMap<>();
        for(int i=0;i<steps.size();i++){
            Step s=steps.get(i);
            System.out.println(s.toString());
            if(!map.containsKey(s.type)&&!s.action.contains("cancel")){
                map.put(s.type,s);
            }else {
                if(map.containsKey(s.type)&&s.action.contains("cancel")){
                    map.remove(s.type);
                }
            }
        }

        for(Map.Entry<Long,Step>entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
        long[]longs=new long[map.size()];
        int k=0;
        for(Map.Entry<Long,Step>entry: map.entrySet()){
            longs[k++]=entry.getValue().stepId;
        }
        Arrays.sort(longs);
        return longs;
    }


}
