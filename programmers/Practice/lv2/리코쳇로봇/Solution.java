package Practice.lv2.리코쳇로봇;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] board = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
        board = new String[]{".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board));
    }
    //우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static int solution(String[] board) {
        int answer = -1;
        int N = board.length;
        int M = board[0].length();
        int sr = 0, sc = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (board[i].charAt(j)=='R') {
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(sr, sc, 0));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            for (int d=0; d<4; d++) {
                int nr = curr.r+dr[d], nc = curr.c+dc[d];
                while (nr>=0 && nr<N && nc>=0 && nc<M && board[nr].charAt(nc)!='D') {
                    nr += dr[d];
                    nc += dc[d];
                }
                nr -= dr[d];
                nc -= dc[d];
                if (board[nr].charAt(nc)=='G') {
                    return curr.d+1;
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Pos(nr, nc, curr.d+1));
                }
            }
        }
        return answer;
    }
    static class Pos {
        int r, c, d;
        Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
