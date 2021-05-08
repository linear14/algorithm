package ryute.topic04.sub02

private fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val trees = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    trees.sort()

    var start = 0L
    var end = trees[n - 1].toLong()
    var ans = 0L

    while(start <= end) {
        // println("start: $start, end: $end")
        val mid = ((start + end) / 2)

        var heights = 0L
        for(tree in trees) {
            if(tree >= mid) {
                heights += tree - mid
            }
        }

        if(heights >= m) {
            ans = mid
            start = mid + 1
        } else {
            end = mid - 1
        }

        // println("heights: $heights, mid: $mid, ans: $ans")
    }
    println(ans)
}