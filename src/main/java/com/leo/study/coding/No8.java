package com.leo.study.coding;

/**
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 * <p>
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 16:58
 */
// a-z=97-122,A-Z=65-90,' '=32
public class No8 {
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] arr = new int[53];
        for (int i = 0; i < s1.length(); i++) {
            int index = getIndex(s1.charAt(i));
            arr[index]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int index = getIndex(s2.charAt(i));
            if (arr[index] == 0) {
                return false;
            }
            arr[index]--;
        }
        return true;
    }

    private int getIndex(char c) {
        if (' ' == c) {
            return 0;
        }
        if (c <= 'Z') {
            return c - 'A' + 1;
        }
        if (c <= 'z') {
            return c - 'a' + 1;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println((int) ' ');
//    }
}
