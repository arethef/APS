package 연습문제.lv2.리코쳇로봇

class Pos (
    val r: Int,
    val c: Int,
    val d: Int,
)

//우하좌상
val dr = arrayOf(0, 1, 0, -1)
val dc = arrayOf(1, 0, -1, 0)

fun solution(board: Array<String>): Int {
    var answer: Int = -1
    val (n, m) = Pair(board.size, board[0].length)
    var (sr, sc) = Pair(0, 0)
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j]=='R') {
                sr = i
                sc = j
                break
            }
        }
    }
    val visited = Array(n){BooleanArray(m)}
    val q = ArrayDeque<Pos>()
    q.addLast(Pos(sr, sc, 0))
    visited[sr][sc] = true
    while (!q.isEmpty()) {
        val curr = q.removeFirst()
        for (d in 0..3) {
            var (nr, nc) = Pair(curr.r+dr[d], curr.c+dc[d])
            while (nr in 0 until n && nc in 0 until m && board[nr][nc]!='D') {
                nr += dr[d]
                nc += dc[d]
            }
            nr -= dr[d]
            nc -= dc[d]
            if (board[nr][nc]=='G') {
                return curr.d+1
            }
            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                q.addLast(Pos(nr, nc, curr.d+1))
            }
        }
    }
    return answer
}

fun main() {
    var board = arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
    println(solution(board))
    board = arrayOf(".D.R", "....", ".G..", "...D")
    println(solution(board))
}