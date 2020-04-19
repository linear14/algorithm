package algorithm_beakjoon

// 200416
// 2864 - 5와 6의 차이

fun main() {
    val builder = StringBuilder()
    val input = readLine()!!.split(" ")
    val (a, b) = input[0] to input[1]

    val arrayA = Array(a.length) { i -> a[i] }
    val arrayB = Array(b.length) { i -> b[i] }
    val indexA = mutableListOf<Int>()
    val indexB = mutableListOf<Int>()

    for((index, char) in arrayA.withIndex()) {
        if(char == '5' || char == '6') {
            indexA.add(index)
        }
    }

    for((index, char) in arrayB.withIndex()) {
        if(char == '5' || char == '6') {
            indexB.add(index)
        }
    }

    for(i in indexA) {
        arrayA[i] = '5'
    }

    for(i in indexB) {
        arrayB[i] = '5'
    }

    for(i in arrayA) {
        builder.append(i.toString())
    }

    val minA = builder.toString().toInt()
    builder.clear()

    for(i in arrayB) {
        builder.append(i.toString())
    }

    val minB = builder.toString().toInt()
    builder.clear()

    for(i in indexA) {
        arrayA[i] = '6'
    }

    for(i in indexB) {
        arrayB[i] = '6'
    }

    for(i in arrayA) {
        builder.append(i.toString())
    }

    val maxA = builder.toString().toInt()
    builder.clear()

    for(i in arrayB) {
        builder.append(i.toString())
    }

    val maxB = builder.toString().toInt()
    builder.clear()

    print("${minA + minB} ${maxA + maxB}")

}

// 이렇게 하면 되는데 ㅎㅎ;; String의 replace함수 활용!
/*

fun main()=with(Scanner(System.`in`)) {
    var A = nextInt()
    var B = nextInt()

    var Amin = A.toString().replace("6","5")
    var Bmin = B.toString().replace("6","5")
    print(Amin.toInt() + Bmin.toInt())

    var Amax = A.toString().replace("5","6")
    var Bmax = B.toString().replace("5","6")
    print(" ")
    print(Amax.toInt() + Bmax.toInt())
}

 */