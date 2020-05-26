package src.algorithm_beakjoon

// 200526
// 11054 - 가장 긴 바이토닉 부분 수열

/*

    양쪽에서 따로따로 LIS 취하는 아이디어를 생각했었는데 가능성을 못 봤었다.
    더 구체적인 방법을 생각 못했던 것인데..
    실제 풀이는 내가 생각했던 아이디어와 같음
    빈 종이에 그려진 내 생각을 구체화시키고 키우는 연습이 필요하다고 본다. (그 방법을 모르겠지만..)

*/

/*

    가장 긴 부분 수열을 구하는 문제에서 조금만 생각을 창의적으로 하면 풀리는 문제다.
    바이토닉 수열의 특징은 특정 수 까지 증가하고 그 이후부터는 감소한다는 것이다.

    가장 긴 부분 수열을 왼쪽에서 오른쪽으로 한번, 오른쪽에서 왼쪽으로 한번 적용하여
    두 배열의 값을 기록해 놓는다면 각 위치까지 가장 긴 증가하는 길이와 감소하는 길이 정보 모두를 얻을 수 있다.
    그리고 두 배열을 합치고 그 중 가장 큰 값을 가져오면 된다.
    단, 자기자신의 길이를 포함하고 있기 때문에 1을 빼준다.

    (출처 : https://wootool.tistory.com/99)

 */

fun main() {
    val n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()

    val dpLeft = Array(n){ 1 }
    val dpRight = Array(n){ 1 }

    for((index, value) in array.withIndex()) {
        for(i in 0 until index) {
            if(value > array[i] && dpLeft[i] >= dpLeft[index]) {
                dpLeft[index] = dpLeft[i] + 1
            }
        }
    }

    /*

    for(i in dpLeft) print("$i ")
    println()

    */

    for(index in n-1 downTo 0) {
        for(i in n-1 downTo index + 1) {
            if(array[index] > array[i] && dpRight[(n-1)-index] <= dpRight[(n-1)-i]) {
                dpRight[(n-1)-index] = dpRight[(n-1)-i] + 1
            }
        }
    }

    /*

    for(i in dpRight) print("$i ")
    println()

    */

    val candidates = Array(n){ i -> dpLeft[i] + dpRight[(n-1)-i] }
    print(candidates.max()!! - 1)
}