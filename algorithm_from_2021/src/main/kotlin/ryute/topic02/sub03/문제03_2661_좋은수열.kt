package ryute.topic02.sub03

private var n: Int = 0
private var str: String = ""
private var isWorkFinished = false

private fun main() {
    n = readLine()!!.toInt()
    backTracking(0)
}

private fun backTracking(level: Int) {
    if(level == n) {
        println(str)
        isWorkFinished = true
        return
    }

    for(i in 1..3) {
        str += i.toString()
        if(isPossible(level)) {
            backTracking(level + 1)
            if(isWorkFinished) return
        }
        str = str.substring(0, str.length - 1)
    }
}

private fun isPossible(level: Int): Boolean {
    val half = (level + 1) / 2
    val strLength = str.length

    for(loop in 1 .. half) {
        if(str.substring(strLength - loop, strLength) == str.substring(strLength - loop - loop, strLength - loop)) {
            return false
        }
    }
    return true
}