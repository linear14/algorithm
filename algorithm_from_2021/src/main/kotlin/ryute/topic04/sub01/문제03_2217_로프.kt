package ryute.topic04.sub01

private fun main() {
    val n = readLine()!!.toInt()
    val ropes = IntArray(n) { readLine()!!.toInt() }.also {
        it.sort()
    }
    val newRopes = ropes.mapIndexed { index, i -> i * (n - index) }
    print(newRopes.sortedDescending()[0])
}