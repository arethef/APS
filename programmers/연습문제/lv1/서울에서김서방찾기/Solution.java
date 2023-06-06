package 연습문제.lv1.서울에서김서방찾기;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }
    static String solution(String[] seoul) {
        return new StringBuilder()
                .append("김서방은 ")
                .append(Arrays.stream(seoul)
                        .collect(Collectors.toList())
                        .indexOf("Kim"))
                .append("에 있다")
                .toString();
    }
}
