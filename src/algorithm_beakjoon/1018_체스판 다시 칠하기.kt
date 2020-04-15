package algorithm_beakjoon

import java.io.*

// 200410 ~ 200415
// 1018 - 체스판 다시 칠하기

fun main() {
    val startWithBlack = Array(8) { i -> Array(8){ j ->
        when(i % 2) {
            0 -> {
                when(j % 2) {
                    0 -> "B"
                    else -> "W"
                }
            }
            else -> {
                when(j % 2) {
                    0 -> "W"
                    else -> "B"
                }
            }
        }
    } }
    val startWithWhite = Array(8) { i -> Array(8){ j ->
        when(i % 2) {
            0 -> {
                when(j % 2) {
                    0 -> "W"
                    else -> "B"
                }
            }
            else -> {
                when(j % 2) {
                    0 -> "B"
                    else -> "W"
                }
            }
        }
    } }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nm = br.readLine().split(" ")
    val (n, m) = nm[0].toInt() to nm[1].toInt()

    val board = MutableList(n){ MutableList(m) {""} }
    for(i in 0 until n){
        val line = br.readLine()
        for(j in 0 until m) {
            board[i][j] = line[j].toString()
        }
    }

    var blackCount = 0
    var whiteCount = 0
    var ans = 1000000
    var row = 0
    var col = 0

    while(row <= n-8 || col <= m-8) {
        for(i in row until row + 8) {
            for(j in col until col + 8) {
                if(board[i][j] != startWithBlack[i - row][j - col]) blackCount++
                if(board[i][j] != startWithWhite[i - row][j - col]) whiteCount++
            }
        }
        val count = if (blackCount >= whiteCount) whiteCount else blackCount

        if(ans > count) ans = count

        if(row == n-8 && col == m-8) break
        if(row == n-8) {
            row = 0
            col++
        } else row++

        blackCount = 0
        whiteCount = 0
    }

    bw.write(ans.toString())
    bw.flush()

}


// 아래는 처음에 작성했던 식. 틀린 식
/*

var count = 0
lateinit var board: MutableList<MutableList<String>>
lateinit var initBoard: MutableList<MutableList<String>>
val lastRowArray = Array(8) { i -> 8 * (i + 1) }
val lastColArray = Array(8) { i -> 57 + i }

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    board = MutableList(n){ MutableList(m) {""} }
    initBoard = MutableList(n){ MutableList(m) {""} }
    sc.nextLine()

    for(i in 0 until n){
        val line = sc.nextLine()
        for(j in 0 until m) {
            board[i][j] = line[j].toString()
            initBoard[i][j] = line[j].toString()
        }
    }

    var ans = 1000000
    var row = 0
    var col = 0

    // 위에서 아래로 내려가는 식으로 진행하자
    while(row <= n-8 || col <= m-8) {
        for(trial in 1..64) {
            val nowRow = row + ((trial - 1) % 8)
            val nowCol = col + ((trial - 1) / 8)
            findWrongPlate(nowRow, nowCol, trial)
        }
        if(ans > count) ans = count
        count = 0

        if(row == n-8 && col == m-8) break
        if(row == n-8) {
            row = 0
            col++
        } else row++

        for(i in board.indices) {
            for(j in board[i].indices) {
                board[i][j] = initBoard[i][j]
            }
        }
    }
    if(ans > 32) print(64 - ans)
    else print(ans)
}

fun findWrongPlate(row: Int, col: Int, trial: Int) {
    if(trial !in lastRowArray) {
        if (board[row][col] == board[row + 1][col]) {
            count++
            if (board[row][col] == "W") board[row + 1][col] = "B"
            else board[row + 1][col] = "W"
        }
    }
    if(trial !in lastColArray) {
        if (board[row][col] == board[row][col + 1]) {
            count++
            if (board[row][col] == "W") board[row][col + 1] = "B"
            else board[row][col + 1] = "W"
        }
    }
}


*/


