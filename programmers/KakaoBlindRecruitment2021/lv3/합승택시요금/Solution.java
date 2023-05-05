package KakaoBlindRecruitment2021.lv3.합승택시요금;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 6, s = 4, a = 6, b = 2;
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };
        System.out.println(solution(n, s, a, b, fares));
        int n2 = 6, s2 = 4, a2 = 5, b2 = 6;
        int[][] fares2 = {
                {2, 6, 6},
                {6, 3, 7},
                {4, 6, 7},
                {6, 5, 11},
                {2, 5, 12},
                {5, 3, 20},
                {2, 4, 8},
                {4, 3, 9}
        };
        System.out.println(solution(n2, s2, a2, b2, fares2));
    }

    static int[][] adjMatrix;
    static final int INF = 200*100_000;
    static int solution(int n, int s, int a, int b, int[][] fares) {
        adjMatrix = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(adjMatrix[i], INF);
        }
        for (int[] f : fares) {
            adjMatrix[f[0]-1][f[1]-1] = f[2];
            adjMatrix[f[1]-1][f[0]-1] = f[2];
        }

        // A와 B가 갈라지는 지점: k
        // 요금 = cost(s, k) + cost(k, a) + cost(k, b)
        int[] costK = dijkstra(n, s-1);
        int[] costA = dijkstra(n, a-1);
        int[] costB = dijkstra(n, b-1);

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            answer = Math.min(answer, costK[i]+costA[i]+costB[i]);
        }
        return answer;
    }

    static int[] dijkstra(int n, int start) {
        int[] cost = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.c-n2.c);

        Arrays.fill(cost, INF);
        cost[start] = 0;
        pq.offer(new Node(start, cost[start]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.to]) {
                continue;
            }
            visited[curr.to] = true;
            for (int i=0; i<n; i++) {
                if (cost[i]>curr.c+adjMatrix[curr.to][i]) {
                    cost[i] = curr.c + adjMatrix[curr.to][i];
                    pq.offer(new Node(i, curr.c+adjMatrix[curr.to][i]));
                }
            }
        }
        return cost;
    }
    static class Node {
        int to, c;
        Node(int to, int c) {
            this.to = to;
            this.c = c;
        }
    }
}
