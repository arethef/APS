package 코딩기초트레이닝.lv0.부분문자열이어붙여문자열만들기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};
        System.out.println(solution(my_strings, parts));
    }

    public static String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length)
                .mapToObj((i) -> my_strings[i].substring(parts[i][0], parts[i][1]+1))
                .reduce("", (a,b) -> a+b);
    }
}
