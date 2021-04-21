package self_boj

private lateinit var table: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private val list = mutableListOf<Char>()
private var ans = Integer.MIN_VALUE

// 좌표 방문여부를 isVisited로 체크하는 방식을 사용했음
// 그로인해, 방문한 [알파벳을 담는 배열]이 하나 더 필요했을 뿐더러
// [알파벳을 담는 배열]에서 새로운 알파벳이 포함되어 있는지 아닌지를 확인하는 로직까지 필요하게 되어버림

private fun main() {
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }

    table = Array(r + 2) { CharArray(c + 2) { '0' } }
    isVisited = Array(r + 2) { BooleanArray(c + 2) }

    for(i in 1..r) {
        val line = readLine()!!
        for(j in 1..c) {
            table[i][j] = line[j - 1]
        }
    }

    list.add(table[1][1])
    isVisited[1][1] = true
    backTracking(1, 1, 1)
    println(ans)
}

private fun backTracking(row: Int, col: Int, level: Int) {

    if(ans <= level) {
        ans = level
    }

    handleVisited(row - 1, col, level)
    handleVisited(row + 1, col, level)
    handleVisited(row, col - 1, level)
    handleVisited(row, col + 1, level)
}

private fun handleVisited(row: Int, col: Int, level: Int) {
    if(!isVisited[row][col] && table[row][col] != '0') {
        isVisited[row][col]

        if(isPossible(table[row][col])) {
            // println("row: $row, col: $col, level: $level")
            list.add(table[row][col])
            backTracking(row, col, level + 1)
            list.removeLast()
        }
        isVisited[row][col] = false
    }
}

private fun isPossible(newWord: Char): Boolean {
    if(newWord in list) return false
    return true
}