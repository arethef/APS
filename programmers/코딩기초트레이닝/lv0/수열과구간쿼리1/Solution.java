package 코딩기초트레이닝.lv0.수열과구간쿼리1;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};
        int[][] queries = {
                {0,1},
                {1,2},
                {2,3}
        };
        System.out.println(Arrays.toString(solution(arr, queries)));
    }
    static int[] solution(int[] arr, int[][] queries) {
        for (int[] q : queries) {
            IntStream.rangeClosed(q[0], q[1])
                    .forEach((i) -> arr[i]++);
        }
        return arr;
    }
}
