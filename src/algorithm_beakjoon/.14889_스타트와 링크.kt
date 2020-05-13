package src.algorithm_beakjoon

import kotlin.math.abs

// 200513
// 14889 - 스타트와 링크

/*
        @params
        teams : 백트래킹의 결과값을 담은 배열을 담는 리스트. 팀이 되는 사람의 숫자끼리를 모아서 배열로 담았다.
        stat : 문제에서 주어지는 가중치 표
 */
fun main() {
    val n = readLine()!!.toInt()
    val list = Array(n / 2){ 0 }
    val teams = mutableListOf<Array<Int>>()

    val stat = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    var min = 1000000

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(list[i] >= list[level]) return false
        }
        return true
    }

    // 백트래킹. 중복되지 않는 숫자의 쌍을 얻어낸다.
    fun backTracking(level: Int) {
        if(level == n / 2) {
            // 새로운 배열을 만들어 team 리스트에 담는다. 이 새로운 배열은 한 팀에 포함되는 인원을 나타낸다.
            val newList = Array(n / 2){ i -> list[i] }
            teams.add(newList)
        } else {
            for(i in 1..n) {
                list[level] = i
                if(isPossible(level)) backTracking(level + 1)
            }
        }
    }

    backTracking(0)

    // 가능한 team을 하나씩 불러온다.
    for(teamFirst in teams) {
        // 상대팀을 만드는 과정.
        val teamSecond =  Array(n / 2){ 0 }
        var index = 0
        for(i in 1..n) {
            if(i !in teamFirst) {
                teamSecond[index] = i
                index++
            }
        }

        var (scoreTeamFirst, scoreTeamSecond) = 0 to 0

        // 각 팀의 점수의 합을 구하는 과정
        for(firstMember in 0 until n / 2) {
            for(secondMember in 0 until n / 2) {
                if(firstMember == secondMember) continue
                else {
                    scoreTeamFirst += stat[teamFirst[firstMember] - 1][teamFirst[secondMember] - 1]
                    scoreTeamSecond += stat[teamSecond[firstMember] - 1][teamSecond[secondMember] - 1]
                }
            }
        }

        val scoreDiff = abs(scoreTeamFirst - scoreTeamSecond)
        if(min > scoreDiff) min = scoreDiff
    }

    print(min)
}