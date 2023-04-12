package Practice.lv0.연속된수의합

fun solution(num: Int, total: Int): IntArray {
//    val start = total/num-(num-1)/2
//    return List(num){ start+it }.toIntArray()
    return (total/num-(num-1)/2).let { start -> IntArray(num) {index -> index+start} }
}

fun main() {
    var num = 3
    var total = 12
    println(solution(num, total).contentToString())
    num = 5
    total = 15
    println(solution(num, total).contentToString())
    num = 4
    total = 14
    println(solution(num, total).contentToString())
}