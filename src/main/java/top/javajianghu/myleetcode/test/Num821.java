package top.javajianghu.myleetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num821 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] result = shortestToChar(s,c);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        char[] chars = s.toCharArray();
        // 记录字符c在字符串s中的位置
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == c){
                list.add(i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            // 默认第一个为最小距离
            int minLength = Math.abs(i - list.get(0));
            if(minLength != 0){
                // 遍历list，找到最小距离
                for (int j = 1; j < list.size(); j++) {
                    minLength = Math.min(minLength, Math.abs(i - list.get(j)));
                    if(minLength == 0){
                        break;
                    }
                }
            }
            res[i] = minLength;
        }
        return res;
    }
}
