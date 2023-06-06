package 카카오인턴십2020.lv3.경주로건설;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[][] board = new int[][]{
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0}
        };
        System.out.println(solution(board));
        board = new int[][] {
                {0,0,1,0},
                {0,0,0,0},
                {0,1,0,1},
                {1,0,0,0}
        };
        System.out.println(solution(board));
        board = new int[][] {
                {0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,0,1,0,0,0},
                {1,0,0,1,0,1},
                {0,1,0,0,0,1},
                {0,0,0,0,0,0}
        };
        System.out.println(solution(board));
    }
    // 우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;

        int[][] cost = new int[N][N];

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0, 0));
        q.add(new Pos(0, 0, 1, 0));

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int cy = curr.y;;
            int cx = curr.x;
            int cd = curr.d;
            int cc = curr.c;
            if (cy==N-1 && cx==N-1) {
                answer = Math.min(answer, cc);
            }
            for (int d=0; d<4; d++) {
                int ny = cy+dy[d];
                int nx = cx+dx[d];
                if (ny<0 || ny>=N || nx<0 || nx>=N || board[ny][nx]==1) continue;
                int nc = cc+((cd+d)%2==0 ? 100 : 600);
                if (visited[ny][nx] && cc+nc>cost[ny][nx]) continue;
                cost[ny][nx] = cc+nc;
                visited[ny][nx] = true;
                q.add(new Pos(ny, nx, d, nc));
            }
        }

        return answer;
    }
    static class Pos {
        int y, x, d, c;
        Pos(int y, int x, int d, int c) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.c = c;
        }
    }

//    // 우하좌상
//    static int[] dy = {0, 1, 0, -1};
//    static int[] dx = {1, 0, -1, 0};
//    static int solution(int[][] board) {
//        int answer = Integer.MAX_VALUE;
//        int N = board.length;
//        int[][] cost = new int[N][N];
//        for (int[] c : cost) {
//            Arrays.fill(c, Integer.MAX_VALUE);
//        }
//        cost[0][0] = 0;
//        Queue<Pos> q = new LinkedList<>();
//        q.add(new Pos(0, 0, 0, 0));
//        q.add(new Pos(0, 0, 1, 0));
//        boolean[][][] visited = new boolean[N][N][4];
//        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] = true;
//        while (!q.isEmpty()) {
//            Pos curr = q.poll();
//            if (curr.y==N-1 && curr.x==N-1) {
//                answer = Math.min(answer, curr.c);
//                continue;
//            }
//            for (int d=0; d<4; d++) {
//                int ny = curr.y+dy[d];
//                int nx = curr.x+dx[d];
//                if (ny<0 || ny>=N || nx<0 || nx>=N || board[ny][nx]==1) {
//                    continue;
//                }
//                int nc = curr.c + ((curr.d+d)%2==0 ? 100 : 600);
//                if (!visited[ny][nx][d] || cost[ny][nx]>=nc) {
//                    cost[ny][nx] = nc;
//                    q.add(new Pos(ny, nx, d, nc));
//                }
//                visited[ny][nx][d] = true;
//            }
//
//        }
//        return answer;
//    }
//    static class Pos {
//        int y, x, d, c;
//        Pos(int y, int x, int d, int c) {
//            this.y = y;
//            this.x = x;
//            this.d = d;
//            this.c = c;
//        }
//        @Override
//        public String toString() {
//            return "Pos {r:"+ y +", c:"+ x +", d:"+d+", c:"+c+"}";
//        }
//    }
}
