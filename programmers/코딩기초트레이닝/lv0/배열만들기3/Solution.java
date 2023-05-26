package 코딩기초트레이닝.lv0.배열만들기3;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[][] intervals = {
                {1,3},
                {0,4}
        };
        System.out.println(Arrays.toString(solution(arr, intervals)));
    }
    static int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();
        for (int[] interval : intervals) {
            answer.addAll(
                    IntStream.rangeClosed(interval[0], interval[1])
                            .mapToObj((i) -> arr[i])
                            .collect(toList())
            );
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
