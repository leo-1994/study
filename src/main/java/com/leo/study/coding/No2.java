package com.leo.study.coding;

import javax.crypto.spec.PSource;

/**
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 * <p>
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 * <p>
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/11 22:07
 */
public class No2 {
    public String reverseString(String iniString) {
        // write code here
        char t;
        char[] chars = iniString.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            t = chars[i];
            chars[i]=chars[j];
            chars[j]=t;
            i++;
            j--;
        }
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new No2().reverseString("abcderf"));
    }
}
