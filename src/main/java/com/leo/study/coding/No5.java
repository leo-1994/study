package com.leo.study.coding;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 * <p>
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 * <p>
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/11 22:59
 */
public class No5 {
    public String zipString(String iniString) {
        // write code here
        if (iniString.length() <= 2) {
            return iniString;
        }
        char[] arr = iniString.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                builder.append(arr[i]).append(count);
                count = 1;
            }
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            builder.append(arr[arr.length - 1]).append(1);
        } else {
            builder.append(arr[arr.length - 1]).append(count);
        }

        String res = builder.toString();
        if (res.length() >= arr.length) {
            return iniString;
        }
        return res;
    }
}
