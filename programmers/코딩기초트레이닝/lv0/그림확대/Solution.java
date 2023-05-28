package 코딩기초트레이닝.lv0.그림확대;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        String[] picture = {
                ".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."
        };
        int k = 2;
        System.out.println(Arrays.toString(solution(picture, k)));
    }
    static String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int idx = 0;
        for (String p : picture) {
            String str = IntStream.range(0, p.length())
                    .mapToObj((i) -> {
                        String s = String.valueOf(p.charAt(i));
                        int cnt = 0;
                        StringBuilder result = new StringBuilder();
                        while (cnt++<k) {
                            result.append(s);
                        }
                        return result.toString();
                    })
                    .collect(Collectors.joining());
            for (int i=0; i<k; i++) {
                answer[idx++] = str;
            }
        }
        return answer;
    }
}
