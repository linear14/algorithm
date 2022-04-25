const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const di = [-1, 1, 0, 0];
const dj = [0, 0, -1, 1];

let n, m;
const arr = [];
rl.on('line', (input) => {
  if(!n) [n, m] = input.split(' ').map(i => +i);
  else {
    arr.push(input.split(''));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  const isVisited = Array.from({ length: n }, () => Array(m).fill(0));
  let finished = false;

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < m; j++) {
      if(isVisited[i][j] === 0) {
        dfs(i, j, 1);
        if(finished) {
          console.log('Yes')
          return;
        }
      }
    }
  }
  console.log('No');

  function dfs(i, j, depth) {
    isVisited[i][j] = depth;
    
    for(let k = 0; k < 4; k++) {
      const ni = i + di[k];
      const nj = j + dj[k];

      if(ni >= 0 && ni < n && nj >= 0 && nj < m) {
        if(arr[i][j] === arr[ni][nj]) {
          if(isVisited[ni][nj] === 0) {
            dfs(ni, nj, depth + 1);
          }
          else {
            if(depth - isVisited[ni][nj] >= 3) {
              finished = true;
            } 
          }
        }
        if(finished) return;
      }
    }
  }
  
});

