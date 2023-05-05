package Practice.lv2.행렬의곱셈;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };
        for (int[] arr : solution(arr1, arr2)) {
            System.out.println(Arrays.toString(arr));
        }
        int[][] arr3 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };
        int[][] arr4 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };
        for (int[] arr : solution(arr3, arr4)) {
            System.out.println(Arrays.toString(arr));
        }
    }
    static int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2[0].length;
        int K = arr2.length;
        int[][] answer = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                for (int k=0; k<K; k++) {
                    sum += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
