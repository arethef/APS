package 연습문제.lv0.다음에올숫자

fun solution(common: IntArray): Int {
    val n = common.size
    return if (common[1]-common[0]==common[2]-common[1]) {
        common[n-1]+(common[n-1]-common[n-2])
    } else {
        common[n-1]*(common[n-1]/common[n-2])
    }
}

fun main() {
    var common = intArrayOf(1, 2, 3, 4)
    println(solution(common))
    common = intArrayOf(2, 4, 8)
    println(solution(common))
}