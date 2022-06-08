const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const di = [0, 0, -1, 1];
const dj = [1, -1, 0, 0];

let n;
const arr = [];

rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) {
      rl.close();
    }
  }  
}).on('close', () => {

  function getStartLand(i, j) {
    for(let k = 0; k < 4; k++) {
      const [ni, nj] = [i + di[k], j + dj[k]];
      if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] !== 0) {
        return arr[ni][nj];
      }
    }
    return undefined;
  }
  
  // 섬들끼리 구분하는 과정 (1 ~ m)
  let q = [];
  let qPointer = 0;
  let landNum = 2;

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(arr[i][j] === 1) {
        arr[i][j] = landNum;
        q.push([i, j]);
        
        while(q.length > qPointer) {
          const [ci, cj] = q[qPointer];
          qPointer++;
          
          for(let k = 0; k < 4; k++){
            const [ni, nj] = [ci + di[k], cj + dj[k]];
            if(ni >= 0 && ni < n && nj >= 0 && nj < n && arr[ni][nj] === 1) {
              arr[ni][nj] = landNum;
              q.push([ni, nj]);
            }
          }
        }
        landNum++;
      }
    }
  }

  // 해당 지역이 바다의 시작이라면 BFS 고고
  let min = Number.MAX_VALUE;
  let isVisited = Array.from({ length: n }, () => Array(n).fill(false));

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(arr[i][j] === 0) {
        const startLand = getStartLand(i, j);
        if(startLand) {
          isVisited = Array.from({ length: n }, () => Array(n).fill(false));
          q = [];
          qPointer = 0;
          
          isVisited[i][j] = true;
          q.push([i, j, 1]);
          
          loop: while(q.length > qPointer) {
            const [ci, cj, depth] = q[qPointer];
            
            for(let k = 0; k < 4; k++) {
              const [ni, nj] = [ci + di[k], cj + dj[k]];
              if(ni >= 0 && ni < n && nj >= 0 && nj < n && !isVisited[ni][nj]) {
                if(arr[ni][nj] === 0) {
                  isVisited[ni][nj] = true;
                  q.push([ni, nj, depth + 1]);                  
                }
                else if(arr[ni][nj] !== startLand) {
                  min = Math.min(min, depth);
                  break loop;
                }
              }
            }
            qPointer++;
          }
        }
      }
    }
  }

  // 경로를 메모이제이션 할 수 있으면 좋을텐데
  console.log(min);
});