package ryute.topic02.sub01

private var n: Int = 0
private var s: Int = 0
private var ans: Int = 0

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.apply {
        n = get(0)
        s = get(1)
    }

    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val visited = Array(n) { false }

    for(i in 1..n) {
        backTracking(arr, visited, 0, 0, i)
    }

    println(ans)
}

private fun backTracking(arr: IntArray, visited: Array<Boolean>, start: Int, level: Int, length: Int) {
    if(level == length) {
        var sum = 0
        for(i in 0 until n) {
            if(visited[i]) {
                sum += arr[i]
            }
        }
        if(sum == s) {
            ans++
        }
        return
    }

    for(i in start until n) {
        visited[i] = true
        backTracking(arr, visited, i + 1, level + 1, length)
        visited[i] = false
    }
}