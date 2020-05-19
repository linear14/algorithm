package src.algorithm_beakjoon

// 200519
// 18290 - NM과 K (1)

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map{ it.toInt() }
    val board = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
    val pair = Array(k){ Pair(0, 0) } // Pair<Int, Int>를 k개 담는 array
    var max = Integer.MIN_VALUE

    fun isPossible(level: Int): Boolean {
        for(i in 0 until level) {
            if(pair[level].first == pair[i].first) {
                if(pair[level].second == pair[i].second - 1 ||
                    pair[level].second == pair[i].second ||
                    pair[level].second == pair[i].second + 1) {
                    return false
                }
            }
            if(pair[level].second == pair[i].second) {
                if(pair[level].first == pair[i].first - 1 ||
                    pair[level].first == pair[i].first ||
                    pair[level].first == pair[i].first + 1) {
                    return false
                }
            }
        }
        return true
    }

    fun backTracking(level: Int) {
        if(level == k) {
            var sum = 0
            for(i in pair) {
                sum += board[i.first][i.second]
            }
            if(max < sum) max = sum

        } else {
            for(i in 0 until n) {
                for(j in 0 until m) {
                    pair[level] = Pair(i, j)
                    if(isPossible(level)) backTracking(level + 1)
                }
            }
        }
    }

    backTracking(0)
    print(max)

}

