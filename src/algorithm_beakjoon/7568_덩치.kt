package algorithm_beakjoon

import java.util.*

// 200409
// 7568 - 덩치

/*
        브루트 포스
        나 자신의 (몸무게 키) 쌍을 다른 사람의 그것과 비교합니다.
        순전히 loop를 돌면서 rank가 증가하는 조건을 만족하면 rank값을 1 증가시킵니다.
 */

fun main() {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    val list = mutableListOf<Pair<Int,Int>>()

    while(n-- > 0) {
        list.add(Pair(sc.nextInt(), sc.nextInt()))
    }

    for((index, pair) in list.withIndex()) {
        var rank = 1
        for(i in 0 until list.size) {
            if(i == index) continue
            if(pair.first < list[i].first && pair.second < list[i].second) rank++
        }
        print("$rank ")
    }
}