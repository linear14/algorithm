package src.algorithm_beakjoon

// 200519
// 6603 - 로또

private var ans = arrayOf<Int>()
private var list = listOf<Int>()
fun main() {
    while(true) {
        list = readLine()!!.split(" ").map{ it.toInt() }
        if(list[0] == 0) return

        ans = Array(6){ 0 }
        backTracking(0)
        println()
    }
}

private fun backTracking(level: Int) {
    if(level == 6) {
        for(i in ans) print("$i ")
        println()
    } else {
        for(i in 1..list[0]) {
            ans[level] = list[i]
            if(isPossible(level)) backTracking(level + 1)
        }
    }
}

private fun isPossible(level: Int): Boolean {
    for(i in 0 until level) {
        if(ans[level] <= ans[i]) return false
    }
    return true
}