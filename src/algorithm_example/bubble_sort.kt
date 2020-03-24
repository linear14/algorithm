package algorithm_example

/*
버블 정렬
- https://youtu.be/EZN0Irp2aPs
- 바로 옆 두 수를 비교해서, 작은 수를 앞으로 보냄.
- 0번, 1번 인덱스의 수 비교. 작은수를 앞으로 -> 1번, 2번 인덱스의 수 비교.... -> 8번, 9번 수 비교
- 1번, 2번 수 비교, ... 8번, 9번 수 비교
- 2번, 3번 수 비교, ... 8번, 9번 수 비교
- 이런식으로 끝 까지 진행하여 정렬
- 시간 복잡도 : n^2
 */

fun bubble_sort() {
    val array = arrayOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)

    var temp: Int?

    for(i in array.indices) {
        for(j in 0 until (array.size - (i + 1))) {
            if(array[j] > array[j + 1]) {
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }

    for(i in array) {
        print("$i ")
    }
}

fun main(args: Array<String>) {
    bubble_sort()
}