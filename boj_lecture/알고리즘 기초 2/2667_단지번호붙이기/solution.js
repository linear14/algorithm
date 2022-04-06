const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split('').map(i => +i));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {

  const ans = [];
  const isVisited = Array.from({ length: n }, () => Array(n).fill(false));
  const di = [1, -1, 0, 0];
  const dj = [0, 0, 1, -1];
  
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(!isVisited[i][j] && arr[i][j] > 0) {
        let count = 0;
        const q = [];
        q.push([i, j]);
        isVisited[i][j] = true;

        while(q.length !== 0) {
          const [ci, cj] = q.shift();
          count++;

          for(let k = 0; k <= 3; k++) {
            const [ni, nj] = [ci + di[k], cj + dj[k]];

            if(ni >= 0 && ni < n && nj >= 0 && nj < n && !isVisited[ni][nj] && arr[ni][nj] > 0) {
              q.push([ni, nj]);
              isVisited[ni][nj] = true;
            }
          }
        }
        ans.push(count);
      }
    }
  }

  console.log(ans.length);
  console.log(ans.sort((a, b) => +a - +b).join('\n'));
});