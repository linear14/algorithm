package algorithm_beakjoon

// 200406
// 1002 - 터렛

fun main() {
    var t = readLine()!!.toInt()
    while(t-- > 0) {
        val input = readLine()!!.split(" ")
        val x1 = input[0].toInt()
        val y1 = input[1].toInt()
        val r1 = input[2].toInt()
        val x2 = input[3].toInt()
        val y2 = input[4].toInt()
        val r2 = input[5].toInt()

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            println(-1)
            continue
        }

        if (r1 < r2) {
            decideDistance(x1, y1, r1, x2, y2, r2)
        } else {
            decideDistance(x2, y2, r2, x1, y1, r1)
        }
    }
}

fun decideDistance(shortX: Int, shortY: Int, shortR: Int, longX: Int, longY: Int, longR: Int) {
    val intervalX = longX - shortX
    val intervalY = longY - shortY
    when(val pointDistanceTwice = (intervalX * intervalX) + (intervalY * intervalY)) {
        // 작은원의 중심이 큰 원 내부에 있을 때
        in 0 until longR * longR -> {
            when((longR - shortR) * (longR - shortR)) {
                in 0 until pointDistanceTwice -> println(2)
                pointDistanceTwice -> println(1)
                else -> println(0)
            }
        }

        // 작은원의 중심이 큰 원의 테두리에 있을 때
        longR * longR -> {
            println(2)
        }

        // 작은원의 중심이 큰 원의 외부에 있을 때
        else -> {
            when((shortR + longR) * (shortR + longR)) {
                in 0 until pointDistanceTwice -> println(0)
                pointDistanceTwice -> println(1)
                else -> println(2)
            }

        }
    }
}
