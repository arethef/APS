package KakaoBlindRecruitment2022.lv3.사라지는발판;

public class Solution {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[] aloc = new int[]{1, 0};
        int[] bloc = new int[]{1, 2};
        System.out.println(solution(board, aloc, bloc));
    }

    // 우하좌상
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};

    static int N, M;

    static int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        N = board.length;
        M = board[0].length;

        Res res = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], true, 0);

        answer = res.cnt;
        return answer;
    }

    static Res dfs(int[][] board, int ar, int ac, int br, int bc, boolean isATurn, int cnt) {
        if ((board[ar][ac]==0 && isATurn) || (board[br][bc]==0 && !isATurn)) {
            return new Res(false, cnt);
        }

        int win = Integer.MAX_VALUE;
        int lose = 0;
        int r, c;
        if (isATurn) {
            r = ar;
            c = ac;
        } else {
            r = br;
            c = bc;
        }

        board[r][c] = 0;

        Res res;
        boolean movePossible = false;
        for (int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr<0 || nr>=N || nc<0 || nc>=M || board[nr][nc]==0) {
                continue;
            }
            movePossible = true;
            if (isATurn) {
                res = dfs(board, nr, nc, br, bc, !isATurn, cnt+1);
            } else {
                res = dfs(board, ar, ac, nr, nc, !isATurn, cnt+1);
            }
            if (res.win) {
                lose = Math.max(lose, res.cnt);
            } else {
                win = Math.min(win, res.cnt);
            }
        }

        board[r][c] = 1;
        if (!movePossible) {
            return new Res(false, cnt);
        } else {
            if (win!=Integer.MAX_VALUE) {
                return new Res(true, win);
            } else {
                return new Res(false, lose);
            }
        }
    }

    static class Res {
        boolean win;
        int cnt;
        Res(boolean win, int cnt) {
            this.win = win;
            this.cnt = cnt;
        }
    }
}
