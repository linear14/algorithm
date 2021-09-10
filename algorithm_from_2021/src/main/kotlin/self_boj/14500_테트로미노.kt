package self_boj

private var n: Int = 0
private var m: Int = 0
private lateinit var arr: Array<IntArray>

private fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    arr = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    val pos2x3 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 0), Pair(1, 1), Pair(1, 2))
    val pos3x2 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1), Pair(2, 0), Pair(2, 1))

    val notInclude2x3 = mutableSetOf(Pair(0, 4), Pair(1, 3), Pair(1, 4), Pair(1, 5), Pair(2, 4))
    val notInclude3x2 = mutableSetOf(Pair(0, 3), Pair(1, 2), Pair(2, 3), Pair(2, 5), Pair(3, 4))

    val calResult = mutableListOf<Int>().apply {
        add(findMax(1, 4))
        add(findMax(4, 1))
        add(findMax(2, 3, pos2x3, notInclude2x3))
        add(findMax(3, 2, pos3x2, notInclude3x2))
    }
    print(calResult.maxOrNull())
}

private fun findMax(rowLength: Int, colLength: Int, pos: Array<Pair<Int, Int>>? = null, notInclude: MutableSet<Pair<Int, Int>>? = null): Int {
    val sumList = mutableListOf<Int>()

    var startRow = 0
    var startCol = 0

    while(true) {
        if(startRow + rowLength > n) {
            return sumList.maxOrNull()!!
        }

        if(startCol + colLength > m) {
            startRow += 1
            startCol = 0
            continue
        }

        val sum = getBlockSum(startRow, rowLength, startCol, colLength)

        if(notInclude !== null) {
            for(i in 0 until 6) {
                for(j in i + 1 until 6) {
                    if(!notInclude.contains(Pair(i, j))) {
                        val blankValue1 = arr[startRow + pos!![i].first][startCol + pos[i].second]
                        val blankValue2 = arr[startRow + pos[j].first][startCol + pos[j].second]
                        sumList.add(sum - blankValue1 - blankValue2)
                    }
                }
            }
        } else {
            sumList.add(sum)
        }

        startCol++
    }
}

private fun getBlockSum(startRow: Int, rowLength: Int, startCol: Int, colLength: Int): Int {
    var sum = 0
    for(i in startRow until startRow + rowLength) {
        for(j in startCol until startCol + colLength) {
            sum += arr[i][j]
        }
    }
    return sum;
}
