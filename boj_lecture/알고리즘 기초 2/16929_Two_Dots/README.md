# 결과

| 메모리(KB) | 시간(ms) | 비고 |
| :--------: | :------: | :--- |
| 10428 | 200 |      |

# 과정

## 생각했던 과정

사이클을 돌아야하니깐 DFS로 돌다가 사이클을 이루면 YES 출력 후 종료하면 될 것 같았다.  
n*m 크기의 방문 배열에 아직 방문하지 않은 배열의 원소를 0으로 설정했다. 순차적으로 순회하면서 dfs를 도는데, dfs의 depth가 깊어질수록 방문 위치에 depth를 기록해둔다.

만약, 방문 배열이 0이 아닌 위치에 도달했을 경우 depth와 방문 배열의 값의 차이가 4이상이라면 사이클을 이룬것으로 판단하고 상황을 종료할 수 있다.