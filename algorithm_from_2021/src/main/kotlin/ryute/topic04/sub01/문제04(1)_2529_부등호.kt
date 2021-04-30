package ryute.topic04.sub01

private var k = 0
private lateinit var cmd: List<String>
private lateinit var checkPoints: List<Int>

private fun main() {
    k = readLine()!!.toInt()
    cmd = readLine()!!.split(" ")

    makeLargest()
    makeSmallest()
}

private fun makeLargest() {
    makeCheckPoints(">")
    val arr = IntArray(k + 1)
    var currentIndex = -1
    var currentNum = 10

    for(i in 1 until checkPoints.size) {
        val interval = checkPoints[i] - checkPoints[i-1]
        currentNum -= interval

        for(offset in 0 until interval) {
            currentIndex++
            arr[currentIndex] = currentNum + offset
        }
    }

    for(i in arr) {
        print("$i")
    }
    println()
}

private fun makeSmallest() {
    makeCheckPoints("<")
    val arr = IntArray(k + 1)
    var currentIndex = k + 1
    var currentNum = k + 1

    // checkPoints: -1, 0, 1, 2, 4, 5, 7, 9 (size: 8)
    // checkPoints: -1, 0, 2

    for(i in 1 until checkPoints.size) {
        val interval = checkPoints[checkPoints.size - i] - checkPoints[checkPoints.size - (i + 1)]
        currentNum -= interval

        for(offset in 0 until interval) {
            currentIndex--
            arr[currentIndex] = currentNum + offset
        }
    }

    for(i in arr) {
        print("$i")
    }
}

private fun makeCheckPoints(sign: String) {
    checkPoints = mutableListOf<Int>().apply {
        add(-1)
        for(i in cmd.indices) {
            if (cmd[i] == sign) {
                add(i)
            }
        }
        add(k)
    }
}

