package src.algorithm_beakjoon

import java.util.*

// 200423
// 1021 - 회전하는 큐

/*

        없앨 항목의 위치에서 1번 인덱스까지 움직이는 최소 방향과 거리를 선택
        mutableList에 담아두었던 m개의 수를 함께 움직여준다.
        (주의할 곳은 시작 지점과 끝 지점에서의 다음 인덱스)
        처리 한 뒤, 삭제된 항목이 있으므로 mutableList의 인덱스를 1씩 추가적으로 빼준다.

 */
fun main() {
    with(Scanner(System.`in`)) {
        var (n, m) = nextInt() to nextInt()
        val mutableList = MutableList(m) { nextInt() }

        var index = 0
        var countSum = 0

        while(index < m) {
            val differWithStart = mutableList[index] - 1
            val differWithEnd = n - mutableList[index] + 1

            if (differWithStart < differWithEnd) {
                countSum += differWithStart
                repeat(differWithStart) {
                    for (i in mutableList.indices) {
                        if (mutableList[i] == 1) mutableList[i] = n
                        else mutableList[i]--
                    }
                }

            } else {
                countSum += differWithEnd
                repeat(differWithEnd) {
                    for (i in mutableList.indices) {
                        if (mutableList[i] == n) mutableList[i] = 1
                        else mutableList[i]++
                    }
                }
            }
            for (i in mutableList.indices) {
                mutableList[i]--
            }
            index++
            n--
        }

        println(countSum)
    }
}