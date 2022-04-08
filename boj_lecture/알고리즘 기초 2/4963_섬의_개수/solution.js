const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const di = [1, -1, 0, 0, 1, 1, -1 ,-1];
const dj = [0, 0, -1, 1, 1, -1, 1, -1];

let cur = 0;
let next = 0;
const whs = [];
const arr = [];
rl.on('line', (input) => {
  if(next === cur) {
    const [w, h] = input.split(' ').map(i => +i);
    if(w === 0 && h === 0) {
      rl.close();
    }
    whs.push([w, h]);
    next += h + 1;
    cur++;
  }
  else {
    arr.push(input.split(' ').map(i => +i));
    cur++;
  }
}).on('close', () => {
  const ans = [];
  let s = 0;
  for(let t = 0; t < whs.length; t++) {
    const [w, h] = whs[t];
    const map = Array.from({ length: h }, (_, idx) => arr[s + idx]);
    const isVisited = Array.from({ length: h }, () => Array(w).fill(false));
    s += h;

    let count = 0;
    for(let i = 0; i < h; i++) {
      for(let j = 0; j < w; j++) {
        if(!isVisited[i][j] && map[i][j] === 1) {
          const q = [];
          q.push([i, j]);
          isVisited[i][j] = true;

          while(q.length !== 0) {
            const [ci, cj] = q.shift();
            
            for(let k = 0; k <= 7; k++) {
              const [ni, nj] = [ci + di[k], cj + dj[k]];
              if(ni >= 0 && ni < h && nj >= 0 && nj < w && map[ni][nj] === 1 && !isVisited[ni][nj]) {
                q.push([ni, nj]);
                isVisited[ni][nj] = true;
              }
            }
          }
          count++;
        }
      }
    }
    ans.push(count);
  }

  console.log(ans.join('\n'));
});