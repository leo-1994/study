package com.leo.study.coding;

/**
 * 题目描述
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * <p>
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/11 16:41
 */
public class No1 {
    public boolean checkDifferent(String iniString) {
        // write code here
        if (iniString.length() > 256) {
            return false;
        }
        boolean[] array = new boolean[256];
        for (int i = 0; i < iniString.length(); i++) {
            int c = iniString.charAt(i);
            if (array[c]) {
                return false;
            } else {
                array[c] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No1().checkDifferent("acbdbesyASDasd1312313dsadasfewfgwg"));
    }
}
