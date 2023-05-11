package Practice.lv2.혼자놀기의달인;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    static int solution(int[] cards) {
        int answer = 0;
        int N = cards.length;
        cards = Arrays.stream(cards).map((i) -> i-1).toArray();
        boolean[] visited = new boolean[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<N; i++) {
            int current = i;
            int count = 0;
            while (!visited[current]) {
                count++;
                visited[current] = true;
                current = cards[current];
            }
            pq.offer(count);

        }
        if (pq.size()>=2) {
            answer = pq.poll()*pq.poll();
        }
        return answer;
    }

//    static int N, maxScore;
//    static boolean[] selected;
//
//    static int solution(int[] cards) {
//        int answer = 0;
//        N = cards.length;
//        cards = Arrays.stream(cards).map((i) -> i-1).toArray();
//        selected = new boolean[N];
//        dfs(0, 0, cards);
//        answer = maxScore;
//        return answer;
//    }
//
//    static void dfs(int currIdx, int cnt, int[] cards) {
//        if (currIdx==N || cnt==2) {
//            maxScore = Math.max(maxScore, getScore(cards));
//            return;
//        }
//
//        for (int i=0; i<N; i++) {
//            if (selected[i]) {
//                continue;
//            }
//            selected[i] = true;
//            dfs(currIdx+1, cnt+1, cards);
//            selected[i] = false;
//        }
//
//    }
//
//    static int getScore(int[] cards) {
//        int[] tgt = IntStream.range(0, N)
//                .filter((i) -> selected[i])
//                .toArray();
//        boolean[] opened = new boolean[N];
//        int number = tgt[0];
//        int one = 0;
//        while (!opened[number]) {
//            opened[number] = true;
//            one++;
//            number = cards[number];
//        }
//        number = tgt[1];
//        int two = 0;
//        while (!opened[number]) {
//            opened[number] = true;
//            two++;
//            number = cards[number];
//        }
//        return one*two;
//    }
}
