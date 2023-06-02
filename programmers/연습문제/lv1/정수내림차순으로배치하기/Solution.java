package 연습문제.lv1.정수내림차순으로배치하기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
    static long solution(long n) {
        return Long.parseLong(
                new StringBuilder()
                        .append(n)
                        .chars()
                        .map(Character::getNumericValue)
                        .mapToObj(String::valueOf)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining())
        );
    }
}
