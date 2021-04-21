package self_boj

private lateinit var table: Array<CharArray>
private lateinit var isVisited: BooleanArray
private var ans = Integer.MIN_VALUE

// 알파벳을 방문했는지 확인하는 용도로 isVisited를 사용했음
// (1) 방법에서 사용했던 [알파벳을 담는 배열]이 필요하지 않으며, 조건을 찾는 로직에 대한 복잡도가 줄어들게 된다.
// (시간이 1/6정도 줄었음)

private fun main() {
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }

    table = Array(r + 2) { CharArray(c + 2) { '0' } }
    isVisited = BooleanArray('Z' - 'A' + 1)

    for (i in 1..r) {
        val line = readLine()!!
        for (j in 1..c) {
            table[i][j] = line[j - 1]
        }
    }

    isVisited[table[1][1] - 'A'] = true
    dfs(1, 1, 1)
    println(ans)
}

private fun dfs(row: Int, col: Int, level: Int) {
    if(ans <= level) {
        ans = level
    }

    handle(row - 1, col, level)
    handle(row + 1, col, level)
    handle(row, col - 1, level)
    handle(row, col + 1, level)
}

private fun handle(newRow: Int, newCol: Int, level: Int) {
    if(table[newRow][newCol] == '0') return
    if(isVisited[table[newRow][newCol] - 'A']) return

    isVisited[table[newRow][newCol] - 'A'] = true
    dfs(newRow, newCol, level + 1)
    isVisited[table[newRow][newCol] - 'A'] = false
}