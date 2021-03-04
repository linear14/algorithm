package ryute.topic02.sub02

private fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }.apply {
        get(0) to get(1)
    }

    var left = a
    var right = b
    while(left != right) {
        if(left > right) {
            right += b
        } else if (left < right) {
            left += a
        }
    }

    val l = left
    val g = (a * b) / l

    println(g)
    println(l)
}