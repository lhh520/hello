package labuladong;

import org.junit.Test;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//同花顺＞铁支＞葫芦＞同花＞顺子＞三条＞两对＞对子＞散牌
public class Compare {
    public String showDown(String inHand) {
        String ans;
        String cs[] = inHand.split(" ");
        if (cs.length < 5) {
            return "GaoPai";
        }

        if (huangjiatonhuashun(cs)) {
            ans = "HuangJiaTongHuaShun";
        } else if (tonhuashun(cs)) {
            ans = "TongHuaShun";
        } else if (sitiaoa(cs)) {
            ans = "SiTiao";
        } else if (hulu(cs)) {
            ans = "HuLu";
        } else if (tonhua(cs)) {
            ans = "TongHua";
        } else if (shunzi(cs)) {
            ans = "ShunZi";
        } else if (santiao(cs)) {
            ans = "SanTiao";
        } else if (liangdui(cs)) {
            ans = "LiangDui";
        } else if (yidui(cs)) {
            ans = "YiDui";
        } else {
            ans = "GaoPai";
        }
        return ans;
    }
    public String[] cntHua(String cs[]) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[2];
        int maxC = 0, v;
        for (String c : cs) {
            c = c.substring(0, 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            v = map.get(c);
            if (v > maxC) {
                maxC = v;
                ans[0] = c;
                ans[1] = v + "";
            }
        }
        return ans;
    }
    public String[] cntNum(String cs[]) {
        Map<String, Integer> map = new HashMap<>();
        int maxCnt = 0, cnt;
        String[] ans = new String[2];
        for (String num : cs) {
            num = num.substring(1);
            map.put(num, map.getOrDefault(num, 0) + 1);
            cnt = map.get(num);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans[0] = maxCnt + "";
                ans[1] = num;
            }
        }
        return ans;
    }
    public void reverse(int nums[]) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public Integer isShunZi(String cs[]) {
        // 1. a为14


        int n = cs.length, nums[] = new int[n];
        String c;
        for (int i = 0; i < n; i++) {
            c = cs[i].substring(1);
            if (c.equals("A")) {
                nums[i] = 14;
            } else if (c.equals("K")) {
                nums[i] = 13;
            } else if (c.equals("Q")) {
                nums[i] = 12;
            } else if (c.equals("J")) {
                nums[i] = 11;
            } else {
                nums[i] = Integer.parseInt(c);
            }
        }
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 0; n - i >= 5; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[j] + 1 != nums[j - 1]) {
                    break;
                }
                if (j - i == 4) {
                    return nums[i];
                }
            }
        }
        // 2. a为1;
        for (int i = 0; i < n; i++) {
            c = cs[i].substring(1);
            if (c.equals("A")) {
                nums[i] = 1;
            } else if (c.equals("K")) {
                nums[i] = 13;
            } else if (c.equals("Q")) {
                nums[i] = 12;
            } else if (c.equals("J")) {
                nums[i] = 11;
            } else {
                nums[i] = Integer.parseInt(c);
            }
        }
        Arrays.sort(nums);
        reverse(nums);

        //1.1 判断是否存在顺子
        for (int i = 0; n - i >= 5; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[j] + 1 != nums[j - 1]) {
                    break;
                }
                if (j - i == 4) {
                    return nums[i];
                }
            }
        }
        return null;
    }
    public boolean huangjiatonhuashun(String cs[]) {
        String[] cnt = cntHua(cs);
        if (Integer.parseInt(cnt[1]) < 5) {
            return false;
        }
        // 获取所有最大次数花色
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].substring(0, 1).equals(cnt[0])) {
                list.add(cs[i]);
            }
        }
        String[] arr = list.toArray(new String[0]);
        Integer shunZi = isShunZi(arr);
        return shunZi != null && shunZi == 14;
    }
    public boolean tonhuashun(String cs[]) {

        String[] cnt = cntHua(cs);
        if (Integer.parseInt(cnt[1]) < 5) {
            return false;
        }
        // 获取所有最大次数花色
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].substring(0, 1).equals(cnt[0])) {
                list.add(cs[i]);
            }
        }
        String[] arr = list.toArray(new String[0]);
        Integer shunZi = isShunZi(arr);
        return shunZi != null;

    }
    public boolean sitiaoa(String cs[]) {
        String[] strings = cntNum(cs);
        return Integer.parseInt(strings[0]) >= 4;
    }
    public boolean hulu(String cs[]) {
        String[] ans = cntNum(cs);
        if (Integer.parseInt(ans[0]) != 3) {
            return false;
        }
        // 获取对应三次的数字字符串
        String rmNum = ans[1];
        List<String> list = new ArrayList<>();
        for (String c : cs) {
            if (!c.substring(1).equals(rmNum)) {
                list.add(c);
            }
        }
        ans = cntNum(list.toArray(new String[0]));
        return Integer.parseInt(ans[0]) >= 2;
    }

    public boolean tonhua(String cs[]) {
        String[] cntHua = cntHua(cs);
        return Integer.parseInt(cntHua[1]) >= 5;
    }

    public boolean shunzi(String cs[]) {
        Integer shunZi = isShunZi(cs);
        return shunZi != null;
    }

    public boolean santiao(String cs[]) {
        String[] ans = cntNum(cs);
        return Integer.parseInt(ans[0]) == 3;

    }
    public boolean liangdui(String cs[]) {
        String[] ans = cntNum(cs);
        if (Integer.parseInt(ans[0]) != 2) {
            return false;
        }
        // 获取对应两次的数字字符串
        String rmNum = ans[1];
        List<String> list = new ArrayList<>();
        for (String c : cs) {
            if (!c.substring(1).equals(rmNum)) {
                list.add(c);
            }
        }
        ans = cntNum(list.toArray(new String[0]));
        return Integer.parseInt(ans[0]) == 2;
    }

    public boolean yidui(String cs[]) {
        String[] ans = cntNum(cs);
        return Integer.parseInt(ans[0]) == 2;
    }
    @Test
    public void test(){
        System.out.println(showDown("SA SK SQ SJ S10 H10 C9"));
    }

    }
