package 연습문제.lv2.테이블해시함수;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int[][] data = {
                {2,2,6},
                {1,5,10},
                {4,2,9},
                {3,8,3}
        };
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(solution(data, col, row_begin, row_end));
    }
    static int solution(int[][] data, int col, int row_begin, int row_end) {
        int N = data.length;
        Arrays.sort(data, (a, b) -> a[col-1]==b[col-1] ? b[0]-a[0] : a[col-1]-b[col-1]);
        int[] modResult = IntStream.range(0, N)
                .map((i) -> Arrays.stream(data[i])
                            .map((num) -> num%(i+1))
                            .sum())
                .toArray();
        int[] targetResult = Arrays.copyOfRange(modResult, row_begin-1, row_end);
        return Arrays.stream(targetResult)
                .reduce((a, b) -> a^b)
                .getAsInt();
    }
}
