package Practice.lv2.연속된부분수열의합;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
    static int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0, right = 0;
        int sum = sequence[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1]-i1[0]==i2[1]-i2[0] ? i1[0]-i2[0] : (i1[1]-i1[0])-(i2[1]-i2[0]));
        while (left != N || right != N) {
            if (sum <= k && right < N) {
                if (sum == k) {
                    pq.offer(new int[]{left, right});
                }

                right++;
                if (right < N) {
                    sum += sequence[right];
                }
            } else {
                if (left < N) {
                    sum -= sequence[left];
                }
                left++;
            }
        }
        return pq.peek();
    }
}
