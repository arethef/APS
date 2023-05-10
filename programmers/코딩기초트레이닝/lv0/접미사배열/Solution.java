package 코딩기초트레이닝.lv0.접미사배열;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        String my_string = "banana";
        System.out.println(Arrays.toString(solution(my_string)));
    }
    static String[] solution(String my_string) {
        return IntStream.range(0, my_string.length())
                .mapToObj(my_string::substring)
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }
}
