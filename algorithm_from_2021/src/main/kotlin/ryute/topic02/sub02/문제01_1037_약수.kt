package ryute.topic02.sub02

private fun main() {
    val n = readLine()!!.toInt()
    var list = readLine()!!.split(" ").map { it.toInt() }
    list = list.sorted()

    println(list[0] * list[list.size - 1])
}