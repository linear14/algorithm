package src.algorithm_beakjoon

// 200512
// 2580 - 스도쿠

fun main() {
    val board = Array(9){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    var flag = false    // 마지막까지 도착해서 출력이 완료가 되었는지를 확인시켜주는 flag

    // 행을 고정시켜 놓은 상태. 열을 바꾸어가며 중복되는 값이 존재하면 false를 반환 (가로줄 체크)
    // 중복되는 값이 없다면 true를 반환하여, 가능한 숫자임을 확인시켜줌
    fun isRowPossible(row: Int, col: Int): Boolean {
        if(flag) return false   // 출력이 1회 완료되었다면 더 이상 출력할 필요가 없으므로 함수 종료
        for (i in 0 until 9) {
            if(i == col) continue   // i와 col이 같다면 아래의 if문은 무조건 참이 되어버린다.
            if (board[row][i] == board[row][col]) return false
        }
        return true
    }

    // 열을 고정시켜 둔 상태. 위와 같은 원리 (세로줄 체크)
    fun isColPossible(row: Int, col: Int): Boolean {
        if(flag) return false
        for(i in 0 until 9) {
            if(i == row) continue
            if(board[i][col] == board[row][col]) return false
        }
        return true
    }

    // 정사각형 체크
    fun isSquarePossible(row: Int, col: Int): Boolean {
        if(flag) return false
        for(i in row / 3 * 3 .. row / 3 * 3 + 2) {
            for(j in col / 3 * 3 .. col / 3 * 3 + 2){
                if(i == row && j == col) continue
                if(board[i][j] == board[row][col]) return false
            }
        }
        return true
    }

    // 세 possible 함수 중 하나라도 거짓이면 가능한 숫자가 아님
    fun isPossible(row: Int, col: Int): Boolean = isRowPossible(row, col) && isColPossible(row, col) && isSquarePossible(row, col)

    // 0이 있는지를 체크하는 함수인데, 왜 만들었지? ㅋㅋ 없어도 될 것 같은데?
    fun isHaveZero(): Boolean {
        for(i in board) for(j in i) {
            if(j == 0) return true
        }
        return false
    }

    fun backTracking(row: Int, col: Int) {
        // 행이 9까지 갔다는 소리는 모든 칸이 채워졌다는 소리가 됨.
        // 따라서 출력하고 상황을 종료하는 flag를 true로 바꾸자.
        if(row == 9) {
            if(!isHaveZero()) {
                flag = true
                for (i in board) {
                    for (j in i) print("$j ")
                    println()
                }
            }
        } else {
            // 매개변수로 들어간 row와 col에 해당하는 위치의 값이 0이 아니라면 다음칸을 조사하면 된다.
            if(board[row][col] != 0) {
                if(col == 8) backTracking(row + 1, 0) else backTracking(row, col + 1)
            } else {
                // 0인 칸에 (즉, 비어있는 칸) 1 ~ 9 까지의 숫자를 차례로 집어넣어보면서, 해당 위치에 그 숫자가 들어갈 수 있는지를 isPossible 함수로 체크한다.
                // 만약 들어갈 수 있다고 판단되면? -> 다음 칸을 조사한다. (backTracking 함수재귀)
                for (i in 1..9) {
                    board[row][col] = i
                    if(isPossible(row, col)) if (col == 8) backTracking(row + 1, 0) else backTracking(row, col + 1)
                }
                // 만약, 숫자 9까지 모두 돌았는데 isPossible이 true인 상황이 없다면?
                // 그 값을 0으로 다시 바꾸어주고, 함수를 호출했던 곳으로 return 시킨다.
                // 그렇게 된다면, 함수를 호출했던 부분의 숫자를 또 1씩 증가시키면서 조사를 진행한다.
                board[row][col] = 0
                return
            }
        }
    }

    backTracking(0, 0)

}