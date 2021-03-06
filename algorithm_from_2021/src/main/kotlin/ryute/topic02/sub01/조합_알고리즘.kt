package ryute.topic02.sub01

private fun main() {
    val n = 5
    val arr = Array(n) { i -> i + 1 }
    val visited = Array(n) { false }

    for(i in 1 .. n) {
        backTracking(arr, visited, 0, n, i)
    }
}

private fun backTracking(arr: Array<Int>, visited: Array<Boolean>, start: Int, n: Int, length: Int) {
    if(length == 0) {
        for(i in 0 until n) {
            if(visited[i]) {
                print("${arr[i]} ")
            }
        }
        println()
    }

    for(i in start until n) {
        visited[i] = true
        backTracking(arr, visited, i + 1, n, length - 1)
        visited[i] = false
    }
}