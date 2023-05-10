package 코딩기초트레이닝.lv0.왼쪽오른쪽;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        String[] str_list = {"u", "u", "l", "r"};
        System.out.println(Arrays.toString(solution(str_list)));
    }

    static public String[] solution(String[] str_list) {
        String[] answer = {};
        String found = Stream.of(str_list).filter((s) -> s.equals("l") || s.equals("r")).findFirst().orElse("");
        if (found.equals("l")) {
            answer = Stream.of(str_list).takeWhile((s) -> !s.equals("l")).toArray(String[]::new);
        }
        if (found.equals("r")) {
            List<String> temp = Stream.of(str_list).dropWhile((s) -> !s.equals("r")).collect(Collectors.toList());
            temp.remove(0);
            answer = temp.toArray(String[]::new);
        }
        return answer;
    }
}
