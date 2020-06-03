package src.algorithm_beakjoon

import kotlin.math.max

// 200527 ~ 200603
// 9251 - LCS

/*

    진짜 어렵다 ㅠㅠ 이런걸 어떻게 생각하지?

    https://118k.tistory.com/483 참고
    https://yabmoons.tistory.com/113 참고

    위의것은 표를 이용한 풀이방법(실제로 LCS값이 어떤 것인지 까지 알 수 있는 방법)
    아래것은 원리

    원리 :
    만약 끝 자리가 서로 같다면? -> 이전 LCS + 1
    끝 자리가 다르다면? -> 각 자리를 붙였다고 가정한 상태에서 더 큰 LCS값 취하기
    아래것 보면 알 수 있을거임..

*/

/*

AABCA
BBCAB
답 : 3

 */

fun main() {
    val a = readLine()!!
    val b = readLine()!!

    val dp = Array(a.length + 1) { Array(b.length + 1) { 0 } }

    for(i in 1..a.length) {
        for(j in 1..b.length) {
            if(a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1] + 1
            else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        }
    }
    println(dp[a.length][b.length])
}




/*
fun main() {
    val a = readLine()!!
    val b = readLine()!!

    // BBCAB : short, AABCA : long
    fun lcs(shortStr: String, longStr: String): Int {
        var max = Integer.MIN_VALUE
        // dp[x][y].first = x번째 단어에서 y번째 시작했을 경우 최대값
        // dp[x][y].second = x번째 단어에서 y번째를 시작으로 했을 경우 마지막 단어의 위치
        val dp = Array(shortStr.length){ i -> Array(i + 1){ Pair(-1, -1) } }

        for(i in shortStr.indices) {
            for(j in 0..i) {
                // 자기 자신에서 새로운 시작
                if(j == i) {
                    // 자신의 문자가 longStr에 존재하는 경우와 아닌 경우.
                    // 아닌 경우에는 Pair(0, -1)로 들어가게 됨
                    val idx = longStr.indexOf(shortStr[j])
                    dp[i][j] = Pair( if(idx == -1) 0 else 1 , idx )
                } else {
                    if(dp[i-1][j].second == -1) {
                        print("${dp[i][j].first} ")
                        continue
                    }

                    val idx = longStr.indexOf(shortStr[i], dp[i-1][j].second + 1)
                    if(idx != -1) dp[i][j] = Pair(dp[i-1][j].first + 1, idx)
                }

                print("${dp[i][j].first} ")
                if(max < dp[i][j].first) max = dp[i][j].first
            }
            println()
        }
        return max

    }

    if(a.length < b.length) print(lcs(a, b)) else print(lcs(b, a))
}
*/





/*
for((index, value) in shortStr.withIndex()) {
    if(value in longStr) dp[index] = Pair(1, longStr.indexOf(value))

    for(i in 0 until index) {
        val whereIdx = longStr.indexOf(value, dp[i].second + 1)
        if(dp[i].first >= dp[index].first && whereIdx > dp[i].second) {
            dp[index] = Pair(dp[i].first + 1, whereIdx)
        }
    }
}
return dp.maxBy{ it.first }!!.first
 */