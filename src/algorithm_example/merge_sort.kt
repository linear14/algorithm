package algorithm_example

/*
병합 정렬
- https://youtu.be/ctkuGoJPmAE
(분할 후 합치기)
- 처음 존재하는 배열을 2로 계속 나누어서 최대한 분할한다.
- 분할 된 각각의 배열은 정렬이 되어있는 상태이다.
- 2개씩 배열을 정렬하며 합친다. 이 때, 1번 배열의 1번 인덱스, 2번 배열의 1번 인덱스를 비교하여 작은 값을 새로운 배열의 1번 인덱스 값으로 설정한다.
- 그 후, 채택된 배열의 인덱스와 새로운 배열의 인덱스를 한 개 씩 늘려 계속 비교한다.
- 시간 복잡도 : NlogN 보장
 */

lateinit var sorted: Array<Int>

fun main(args: Array<String>) {
    val array = arrayOf(7, 6, 5, 8, 3, 5, 9, 1)
    sorted = Array(array.size) {0}
    mergeSort(array, 0, array.size - 1)
    for(i in array) {
        print("$i ")
    }
}

fun mergeSort(array: Array<Int>, start: Int, end: Int) {
    if(start < end) {
        val middle = (start + end) / 2
        mergeSort(array, start, middle)
        mergeSort(array, middle + 1, end)
        merge(array, start, middle, end)
    }
}

fun merge(array: Array<Int>, start: Int, middle: Int, end: Int) {
    var firstArrayIndex = start
    var secondArrayIndex = middle + 1
    var mergedArrayIndex = start

    while (firstArrayIndex <= middle && secondArrayIndex <= end) {
        if (array[firstArrayIndex] <= array[secondArrayIndex]) {
            sorted[mergedArrayIndex] = array[firstArrayIndex]
            firstArrayIndex++
        } else {
            sorted[mergedArrayIndex] = array[secondArrayIndex]
            secondArrayIndex++
        }
        mergedArrayIndex++
    }

    if (firstArrayIndex > middle) {
        while (secondArrayIndex <= end) {
            sorted[mergedArrayIndex] = array[secondArrayIndex]
            secondArrayIndex++
            mergedArrayIndex++
        }
    } else {
        while (firstArrayIndex <= middle) {
            sorted[mergedArrayIndex] = array[firstArrayIndex]
            firstArrayIndex++
            mergedArrayIndex++
        }
    }

    for(i in start .. end) {
        array[i] = sorted[i]
    }
}