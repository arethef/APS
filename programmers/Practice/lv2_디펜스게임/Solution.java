package Practice.lv2_디펜스게임;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = new int[]{4, 2, 4, 5, 3, 3, 1};
        System.out.println(solution(n, k, enemy));
        n = 2;
        k = 4;
        enemy = new int[]{3, 3, 3, 3};
        System.out.println(solution(n, k, enemy));
    }
    public static int solution(int n, int k, int[] enemy) {
        int round = enemy.length;
        int answer = round;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<round; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];
            if (n<0) {
                if (k>0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
