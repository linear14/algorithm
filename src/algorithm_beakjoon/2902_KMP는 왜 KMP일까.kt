package algorithm_beakjoon

// 200412
// 2902 - KMP는 왜 KMP일까?

fun main(args: Array<String>) {
    val builder = StringBuilder()
    val input = readLine()!!.split("-")
    for(i in input) {
        builder.append(i[0])
    }
    print(builder.toString())
}