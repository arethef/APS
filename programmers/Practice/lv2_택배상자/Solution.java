package Practice.lv2_택배상자;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] order = new int[]{5, 4, 3, 2, 1};
        System.out.println(solution(order));
        order = new int[]{4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }
    static int solution(int[] order) {
        int answer = 0;
        int N = order.length;
        Stack<Integer> sub = new Stack<>();
        int srcIdx = 1;
        int tgtIdx = 0;
        while (true) {
            if (!sub.isEmpty() && order[tgtIdx]==sub.peek()) {
                answer++;
                tgtIdx++;
                sub.pop();
                continue;
            }
            if (srcIdx>N) {
                break;
            }
            if (order[tgtIdx]==srcIdx) {
                answer++;
                srcIdx++;
                tgtIdx++;
                continue;
            }
            sub.push(srcIdx);
            srcIdx++;
        }
        return answer;
    }
}
