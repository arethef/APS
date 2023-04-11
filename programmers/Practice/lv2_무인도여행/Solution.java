package Practice.lv2_무인도여행;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] maps = new String[]{"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(solution(maps));
    }

    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean[][] visited;
    static int N, M;
    public static ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] || maps[i].charAt(j)=='X') {
                    continue;
                }
                answer.add(bfs(i, j, maps));
            }
        }

        if (answer.size()!=0) {
            Collections.sort(answer);
        } else {
            answer.add(-1);
        }

        return answer;
    }
    static int bfs(int sr, int sc, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int sum = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            sum += maps[curr[0]].charAt(curr[1])-48;
            for (int d=0; d<4; d++) {
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];
                if (nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || maps[nr].charAt(nc)=='X') {
                    continue;
                }
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        return sum;
    }
}
