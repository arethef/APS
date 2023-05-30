package 연습문제.lv2.귤고르기;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, tangerine));
    }
    static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> t2-t1);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e.getValue());
        }
        while (k>0 && !pq.isEmpty()) {
            k -= pq.poll();
            answer++;
        }
        return answer;
    }
}
