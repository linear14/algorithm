package src.algorithm_beakjoon

// 200502
// 1100 - 하얀 칸

fun main() {
    var count = 0
    for(i in 1..8) {
        val line = readLine()!!
        for((index, char) in line.withIndex()) {
            if(i % 2 == 1) { if(index % 2 == 0 && char == 'F') count++ }
            else { if(index % 2 == 1 && char == 'F') count++ }
        }
    }
    print(count)
}