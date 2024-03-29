# 결과

| 메모리(KB) | 시간(ms) | 비고 |
| :--------: | :------: | :--- |
| 17332 | 224 |      |

# 과정

## 일단 생각나는대로 구현했더니..

예전의 기억을 되살려서 구현을 진행했다. 학습했을 때는 dfs의 경우 스택을 이용하고, bfs의 경우 큐를 이용해 노드 탐색을 한다고 했었다. 하지만, dfs의 경우 재귀로 접근해보고 싶었는데, 이게 더 일반적으로 많이 사용하는 방식 같았기 때문이다.

DFS의 경우 필요없는 연산을 더이상 안하도록 만들고 싶어서, 탐색 가능한 모든 노드들을 모아둔 Set의 길이와 dfs 결과 원소 배열의 길이가 같아지면 탐색을 종료하기로 구성했다.

하지만, 코드가 지저분하다고 느꼈으며, 자주 사용되는 풀이법이므로 다른 분들의 코드를 보면서 어떻게 접근하셨는지 볼 필요성을 느꼈다.

## 다른 사람들의 코드를 보고 나서..

### DFS

나는 DFS의 탐색이 종료되었다는 flag를 설정하고, 외부 함수에서 내부 재귀 함수의 호출이 끝날 경우 flag를 체크해 탐색이 종료되었다면 이후 로직을 수행하지 않도록 코드를 짰었다. 하지만, dfs() 호출이 dfs 선언의 마지막 부분이라 굳이 체크할 필요는 없었다. (어차피 return 후에는 더이상 실행될 문이 없으니깐..) 그래서, 그냥 for문 시작점에서만 체크하면 될 것 같다고 생각했는데, 굳이 해야되나 싶기도 하다. 왜냐하면.. 불필요한 for문을 돌리는 비용이나 불필요한 if문을 돌리는 비용이나 어떤게 더 클지는 런타임 전까지 알 수 없기 때문이다..!

### BFS

`정답 배열에 언제 원소를 집어넣을까?` 라는 생각을 하게 됐다. 나는 bfs의 경우 큐에 원소를 `넣을 때` 정답 배열에도 원소를 넣었다. 하지만, 다른 사람들은 큐에서 원소를 `뺄 때` 정답 배열에 원소를 넣었다. (방문여부 체크도 마찬가지..) 애초에 나는 큐에 값을 넣을 때 부터 확실한 값들만 넣었던 것이다. 이렇게 하면 불필요한 값이 큐에 안들어가니깐 메모리 관점에서 더 좋은거 아닐까??


# 참고 자료
- [참고한 코드](https://www.acmicpc.net/source/41249031)
