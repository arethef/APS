package 코딩기초트레이닝.lv0.배열만들기5;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] intStrs = {"0123456789","9876543210","9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;
        System.out.println(Arrays.toString(solution(intStrs, k, s, l)));
    }
    static int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
                .map((str) -> str.substring(s, s+l))
                .filter((str) -> Integer.parseInt(str)>k)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
