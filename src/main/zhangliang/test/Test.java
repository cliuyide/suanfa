package main.zhangliang.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static void selectMFromList(char[] cs, int m, List<Character> item, List<List<Character>> result) {
        for (int i = 0; i < cs.length; i++) {
            item.add(cs[i]);
            if (m == 1) {
                result.add(new ArrayList<>(item));
            } else {
                selectMFromList(Arrays.copyOfRange(cs, i + 1, cs.length), m - 1, item, result);
            }
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("1:" + who("xfircvscxggbwkf"));// -> 1
        System.out.println("1:" + who("nqduxwfnfozvsrt"));// -> 1
        System.out.println("1:" + who("kjprepggxrpnrvy"));// -> 1
        System.out.println("1:" + who("stmwcysyycqpevi"));// -> 1
        System.out.println("0:" + who("keffmznimkkasvw"));// -> 0
        System.out.println("1:" + who("srenzkycxfxtlsg"));// -> 1
        System.out.println("0:" + who("ypsfadpooefxzbc"));// -> 0
        System.out.println("1:" + who("oejuvpvaboygpoe"));// -> 1
        System.out.println("1:" + who("ylfpbnpljvrvipy"));// -> 1
        System.out.println("0:" + who("amyehwqnqrqpmxu"));// -> 0
        System.out.println("1:" + who("jjloovaowuxwhms"));// -> 1
        System.out.println("1:" + who("ncbxcoksfzkvatx"));// -> 1
        System.out.println("1:" + who("dknlyjyhfixjswn"));// -> 1
        System.out.println("1:" + who("kkufnuxxzrzbmnm"));// -> 1
        System.out.println("1:" + who("gqooketlyhnkoau"));// -> 1
        System.out.println("1:" + who("gzqrcddiuteiojw"));// -> 1
        System.out.println("0:" + who("ayyzpvscmpsajlf"));// -> 0
        System.out.println("1:" + who("vgubfaaovlzylnt"));// -> 1
        System.out.println("1:" + who("rkdcpwsrtesjwhd"));// -> 1

    }

    public static boolean isStrictNaturalOrder(List<Character> list) {
        if (list == null || list.size() == 0) return false;
        if (list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int who(String s) {
        return 0;
    }
}
