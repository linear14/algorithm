const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m, v;
const arr = [];
let graph;
let isVisited; 

rl.on('line', (input) => {
  if(!n) [n, m, v] = input.split(' ').map(i => +i);
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === m) rl.close();
  }
}).on('close', () => {

  graph = Array.from({ length: n+1 }, () => []);
  for(let i = 0; i < arr.length; i++) {
    nCnt.add(arr[i][0]);
    nCnt.add(arr[i][1]);
    graph[arr[i][0]].push(arr[i][1]);
    graph[arr[i][1]].push(arr[i][0]);
  }
  for(let i = 0; i < graph.length; i++) {
    graph[i].sort((a, b) => a - b);
  }

  isVisited = Array(n+1).fill(false);
  isVisited[v] = true;
  dfsNodes.push(v);
  dfs(v);

  isVisited = Array(n+1).fill(false);
  bfs();

  console.log(dfsNodes.join(' '));
  console.log(bfsNodes.join(' '));
});

const dfsNodes = [];
let nCnt = new Set();
let isEnd = false;
const dfs = (cur) => {
  if(dfsNodes.length === nCnt.length) {
    isEnd = true;
    return;
  }
  
  const nextNodes = graph[cur];
  for(let i = 0; i < nextNodes.length; i++) {
    if(isEnd) return;

    const next = nextNodes[i];
    if(!isVisited[next]) {
      dfsNodes.push(next);
      isVisited[next] = true;
      dfs(next);
      if(isEnd) return;
    }
  }
}

const bfsNodes = [];
const bfs = () => {
  const q = [];
  q.unshift(v);
  bfsNodes.push(v);
  isVisited[v] = true;

  while(q.length !== 0) {
    const cur = q.pop();
    for(let i = 0; i < graph[cur].length; i++) {
      const next = graph[cur][i];
      if(!isVisited[next]) {
        bfsNodes.push(next);
        isVisited[next] = true;
        q.unshift(next);
      }
    }
  }
}