package src.algorithm_example

import java.util.*

/*

    @params
    n : node 갯수
    s : 시작 node
    (참고로 간선의 개수는 필요 없을듯) : add 함수가 한 개 사용될 때 마다 간선이 1개 늘어남

 */

class Search(val n: Int) {
    // 인접 리스트
    private val adj = Array(n + 1) { mutableListOf<Int>() }
    // 방문 여부
    private var visit = Array(n + 1) { 0 }

    // 양방향 edge 생성 (인접 리스트에 담기)
    fun add(from: Int, to: Int) {
        adj[from].add(to)
        adj[to].add(from)
    }

    // 인접 리스트 내에 들어있는 node의 값을 오름차순으로 정렬
    fun sort() {
        for(i in adj) i.sort()
    }

    fun initVisit() {
        visit = Array(n + 1) { 0 }
    }

    // s를 시작으로 하는 깊이우선탐색
    fun dfs(s: Int) {
        if(visit[s] == 0) print("$s ")
        visit[s] = 1

        for(i in adj[s]) {
            if(visit[i] == 0) {
                dfs(i)
            }
        }
    }

    // s를 시작으로 하는 너비우선탐색
    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.add(s)
        visit[s] = 1

        while(!q.isEmpty()) {
            val item = q.remove()
            print("$item ")

            for(i in adj[item]) {
                if(visit[i] == 0) {
                    q.add(i)
                    visit[i] = 1
                }
            }
        }
    }
}

fun main() {
    with(Search(6)) {
        add(1, 3)
        add(1, 5)
        add(1, 6)
        add(2, 6)
        add(3, 4)
        add(4, 6)
        add(5, 6)
        sort()

        dfs(1)
        initVisit()
        println()
        bfs(1)
    }
}
