package src.algorithm_beakjoon

// 200604
// 2630 - 색종이 만들기

fun main() {
    val n = readLine()!!.toInt()
    val board = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }

    var white = 0
    var blue = 0

    fun divide(startX: Int, startY: Int, size: Int) {
        var flag = true
        val temp = board[startX][startY]
        if(size == 1) {
            if(temp == 0) white++
            else blue++
        } else {
            loop@for(i in 0 until size) {
                for(j in 0 until size) {
                    if (temp != board[startX + i][startY + j]) {
                        divide(startX, startY, size / 2)
                        divide(startX + size / 2, startY, size / 2)
                        divide(startX, startY + size / 2, size / 2)
                        divide(startX + size / 2, startY + size / 2, size / 2)
                        flag = false
                        break@loop
                    }
                }
            }
            // 전체가 한가지 색으로 칠해진 경우에 대한 처리
            if(flag) divide(startX, startY, 1)
        }
    }

    divide(0, 0, n)

    println(white)
    println(blue)
}