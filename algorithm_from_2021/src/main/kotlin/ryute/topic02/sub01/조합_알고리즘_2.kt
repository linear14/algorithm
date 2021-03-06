package ryute.topic02.sub01

private val n  = 5

private fun main() {
    val arr = Array(n) { i -> i + 1 }
    val visited = Array(n) { false }

    for(i in 1 .. n) {
        backTracking(arr, visited, 0,0, i)
    }
}

private fun backTracking(arr: Array<Int>, visited: Array<Boolean>, start: Int, level: Int, length: Int) {
    if(level == length) {
        for(i in 0 until n) {
            if(visited[i]) {
                print("${arr[i]} ")
            }
        }
        println()
        return
    }

    for(i in start until n) {
        visited[i] = true
        backTracking(arr, visited, i + 1, level + 1, length)
        visited[i] = false
    }
}

