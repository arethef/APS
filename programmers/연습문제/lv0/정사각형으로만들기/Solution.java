package 연습문제.lv0.정사각형으로만들기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1 = {
                {572, 22, 37},
                {287, 726, 384},
                {85, 137, 292},
                {487, 13, 876}
        };
        int[][] res1 = solution(arr1);
        for (int[] a : res1) {
            System.out.println(Arrays.toString(a));
        }
        int[][] arr2 = {
                {57, 192, 534, 2},
                {9, 345, 192, 999}
        };
        int[][] res2 = solution(arr2);
        for (int[] a : res2) {
            System.out.println(Arrays.toString(a));
        }
    }
    static int[][] solution(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int S = Math.max(N, M);
        int[][] answer = new int[S][S];
        for (int i=0; i<S; i++) {
            if (i>=N) {
                continue;
            }
            for (int j=0; j<S; j++) {
                if (j>=M) {
                    continue;
                }
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}
