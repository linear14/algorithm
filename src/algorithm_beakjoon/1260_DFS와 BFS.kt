package src.algorithm_beakjoon

import java.util.*

// 200607
// 1260 - DFS와 BFS
// https://manducku.tistory.com/24 (BFS에 대한 이해)
// https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
// https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html
// https://sarah950716.tistory.com/12 (인접 리스트와 인접 행렬에 관한 설명)


fun main() {
    val input = readLine()!!.split(" ").map{ it.toInt() }
    val n = input[0]
    val m = input[1]
    val v = input[2]

    // 인접 리스트로, 간선으로 연결된 노드 집어넣기 + 양방향
    val adj = Array(n + 1){ mutableListOf<Int>() }
    for(i in 0 until m) {
        val (from, to) = readLine()!!.split(" ").map{ it.toInt() }
        adj[from].add(to)
        adj[to].add(from)
    }

    // 각 노드와 연결된 노드를 오름차순으로 정렬 (문제에서 작은 수의 정점부터 출력하라는 조건)
    for(i in adj) i.sort()


    // DFS는 재귀를 이용
    val visitDFS = Array(n + 1) { 0 }
    fun dfs(node: Int) {
        if(visitDFS[node] == 0) print("$node ")

        visitDFS[node] = 1

        for(item in adj[node]) {
            if(visitDFS[item] != 1) {
                dfs(item)
            }
        }
    }


    // BFS는 재귀를 이용하지 않음
    val visitBFS = Array(n + 1) { 0 }
    fun bfs(node: Int) {
        val queue = LinkedList<Int>()
        queue.add(node)
        visitBFS[node] = 1

        while(!queue.isEmpty()) {
            val selected = queue.remove()
            print("$selected ")

            for(item in adj[selected]) {
                if(visitBFS[item] != 1) {
                    visitBFS[item] = 1
                    queue.add(item)
                }
            }
        }
    }

    dfs(v)
    println()
    bfs(v)
}