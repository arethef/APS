package 코딩기초트레이닝.lv0.특이한이차원배열1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[][] result = solution(n);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
    static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        Arrays.setAll(answer, i -> {
            int[] arr = answer[i];
            arr[i] = 1;
            return arr;
        });
        return answer;
    }
}
