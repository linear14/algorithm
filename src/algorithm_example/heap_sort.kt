package algorithm_example

/*
힙 정렬
 */

// 상향식
fun heapifyBottomUp(array: Array<Int>) {
    // 우선 최대 힙을 구성해야 함 (Log N 의 시간 복잡도) (상향식)
    for (i in 1 until array.size) {
        var child = i
        do {
            val root = (child - 1) / 2
            if (array[root] < array[child]) {
                val temp = array[root]
                array[root] = array[child]
                array[child] = temp
            }
            child = root
        } while (child != 0)
    }
    heapSort(array)
}

// 하향식
fun heapifyTopDown(array: Array<Int>) {
    for(i in array.size / 2 - 1 downTo 0) {
        var root = i
        while(root <= array.size / 2 - 1) {
            val firstNode = 2 * root + 1
            val secondNode = 2 * root + 2
            var selectedChild: Int?

            // 자식 노드의 값 중에서 더 큰 값의 index를 찾기
            if(secondNode > array.size - 1) {
                selectedChild = firstNode
            } else {
                if (array[firstNode] < array[secondNode]) {
                    selectedChild = secondNode
                } else {
                    selectedChild = firstNode
                }
            }

            // root와 비교하여 자식 노드 값이 더 크면 자리 바꾸기
            if(array[root] < array[selectedChild]) {
                val temp = array[root]
                array[root] = array[selectedChild]
                array[selectedChild] = temp
            }
            root = selectedChild
        }
    }
    heapSort(array)
}

fun heapSort(array: Array<Int>) {
    for(i in array.size - 1 downTo 0) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp

        var child: Int
        var root = 0

        do {
            child = 2 * root + 1
            if(child < i - 1 && array[child] < array[child + 1]) {
                child++
            }
            if (child < i && array[root] < array[child]) {
                val temp = array[root]
                array[root] = array[child]
                array[child] = temp
            }
            root = child
        } while (child < i)
    }


}

fun main(args: Array<String>) {
    val array = arrayOf(7, 6, 5, 8, 3, 5, 9, 1, 6)
    heapifyBottomUp(array)
    for(i in array){
        print("$i ")
    }

    println()
    println("============================")

    val array_downward = arrayOf(10, 26, 5, 37, 1, 61, 5, 11, 59, 15, 19, 48)
    heapifyTopDown(array_downward)
    for(i in array_downward) {
        print("$i ")
    }
}

