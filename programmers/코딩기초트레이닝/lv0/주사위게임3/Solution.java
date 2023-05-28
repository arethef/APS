package 코딩기초트레이닝.lv0.주사위게임3;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2, 2, 2, 2));
        System.out.println(solution(4, 1, 4, 4));
        System.out.println(solution(6, 3, 3, 6));
        System.out.println(solution(2, 5, 2, 6));
        System.out.println(solution(6, 4, 2, 5));
    }
    static int solution(int a, int b, int c, int d) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : List.of(a, b, c, d)) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int diffCount = map.size();
        if (diffCount==1) {
            answer = 1111*a;
        } else if (diffCount==4) {
            answer = Math.min(
                    Math.min(a, b),
                    Math.min(c, d)
            );
        } else {
            int[] num = map.keySet().stream()
                    .sorted((i1, i2) -> map.get(i2)-map.get(i1))
                    .mapToInt(Integer::intValue)
                    .toArray();
            if (diffCount==2) {
                if (map.get(a)==2) {
                    answer = (num[0]+num[1])*Math.abs(num[0]-num[1]);
                } else {
                    answer = (int) Math.pow(10*num[0]+num[1], 2);
                }
            } else if (diffCount==3) {
                answer = num[1]*num[2];
            }
        }
        return answer;
    }
}
