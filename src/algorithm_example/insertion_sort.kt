package algorithm_example

/*
삽입 정렬
- https://youtu.be/16I9Z7bS1iM
- 각 인덱스의 숫자들이, 자신보다 왼쪽에 있는 숫자들 사이에서 자신이 있기에 적합한 위치에 들어가는 원리
- 장점 : 자신의 왼쪽에 있는 숫자들은 이미 정렬이 모두 되어있는 상태이므로, 왼쪽에 있는 숫자들을 보다가 자신보다 작음이 확인되면 중단
- 시간 복잡도 : n^2 하지만, 거의 정렬되어 있는 상태에서는 정말 효율적인 정렬 방법 (n^2중 최강)
 */

fun insertion_sort() {
    val array = arrayOf(26, 5, 37, 1, 61, 11, 37, 15, 48, 19)

    var temp: Int?
    for(i in array.indices) {
        for(j in i downTo 1) {
            if(array[j - 1] > array[j]) {
                temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            } else {
                break
            }
        }
    }


    for(i in array) {
        print("$i ")
    }
}

fun main(args: Array<String>) {
    insertion_sort()
}