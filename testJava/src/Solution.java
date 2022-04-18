import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // 输入函数，用于把输入的结果放到集合中
    public static List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
        // 次数，行数
        int times = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            // 每一行
            list.add(scanner.next());
        }
        return list;
    }

    // 输出函数，用于把结果集合转变为输出
    public static void output(List<Boolean> result) {
        for (Boolean s : result) {
            // 根据 s 的 true 和 false 来返回
            System.out.println(s ? "Accept" : "Wrong");
        }
    }

    // 用户名的首字符必须是大写或者小写字母。
    // 用户名只能包含大小写字母，数字。
    // 用户名需要包含至少一个字母和一个数字。
    public static boolean check(String input) {
        // 用户名需要包含至少一个字母和一个数字，长度至少为2
        if (input.length() < 2)
            return false;

        // 用户名的首字符必须是大写或者小写字母。
        char firstLetter = input.charAt(0);
        if (!(firstLetter >= 'a' && firstLetter <= 'z') && !(firstLetter >= 'A' && firstLetter <= 'Z'))
            return false;

        // 数字的个数
        int numOfNums = 0;
        for (char ch : input.toCharArray()) {
            // 用户名只能包含大小写字母，数字。
            // 统计数字个数
            if (ch >= '0' && ch <= '9')
                numOfNums++;
                // 用户名只能包含大小写字母，数字。
            else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                continue;
            else
                return false;
        }
        // 用户名的首字符必须是大写或者小写字母了，所以只需要判断条件至少一个数字。
        return numOfNums != 0;
    }

    public static void main(String[] args) {
        List<String> list = getInput();
        List<Boolean> res = new ArrayList<>();
        for (String eachTry : list) {
            res.add(check(eachTry));
        }
        output(res);
    }
}
