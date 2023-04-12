package Practice.lv0_옹알이_1_

fun solution(babbling: Array<String>): Int {
    val regex = "aya|ye|woo|ma".toRegex()
    return babbling.map { it.replace(regex, "") }.count { it.isEmpty() }
}

fun main() {
    val babbling = arrayOf("aya", "yee", "u", "maa", "wyeoo")
    println(solution(babbling))
}