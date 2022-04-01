const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let m;
const arr = [];
let graph;

rl.on('line', (input) => {
  if(!n && !m) {
    [n, m] = input.split(' ').map(i => +i);
  }
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === m) {
      rl.close();
    }
  }
}).on('close', () => {
  graph = Array.from({ length: n }, () => []);

  for(let i = 0 ; i < m; i++) {
    const [p1, p2] = arr[i];
    graph[p1].push(p2);
    graph[p2].push(p1);
  }

  for(let i = 0; i < n; i++) {
    if(isEnd) break;

    isVisited[i] = true;
    dfs(i, 1);
    isVisited[i] = false;
  }

  console.log(isEnd ? 1 : 0);
});

let isEnd = false;
const isVisited = Array(n).fill(false);

const dfs = (cur, count) => {
  if(count === 5) {
    isEnd = true;
    return;
  }

  const nextArr = graph[cur];
  for(let i = 0; i < nextArr.length; i++) {
    if(isEnd) return;

    const next = nextArr[i];
    if(!isVisited[next]) {
      isVisited[next] = true;
      dfs(next, count + 1);
      isVisited[next] = false;
    }
  }
}