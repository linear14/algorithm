const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n, m;
const arr = [];
let isVisited;
rl.on('line', (input) => {
  if(!n) {
    [n, m] = input.split(' ').map(i => Number(i));
    isVisited = Array.from({ length: 2 }, 
      () => Array.from({ length: n }, 
      () => Array.from({ length: m }, 
      () => false)));
  }
  else {
    arr.push(input.split('').map(i => Number(i)));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  const d = [[-1, 0], [1, 0], [0, 1], [0, -1]];
  const q = [];
  q.push([0, 0, 1, false]);
  isVisited[0][0][0] = true;

  while(q.length > 0) {
    const [cy, cx, cnt, isBroken] = q.shift();
    if(cy === n - 1 && cx === m - 1) return cnt;

    for(let i = 0; i <= 3; i++) {
      const [ny, nx] = [cy + d[i][0], cx + d[i][1]];

      if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
        // 내가 벽을 부순적이 있다면
        if(isBroken) {
          // 부순 상태에서 방문하지 않은 땅만 갈 수 있다.
          if(!isVisited[1][ny][nx] && arr[ny][nx] === 0) {
            q.push([ny, nx, cnt + 1, true]);
            isVisited[1][ny][nx] = true;
          }
        }
        // 내가 지금까지 벽을 부수지 않았다면..?
        else {
          if(!isVisited[0][ny][nx]) {
            // 벽일 경우에 부수는 것을 택하거나.. 안부수는 것을 택한다
            if(arr[ny][nx] === 1) {
              q.push([ny, nx, cnt + 1, true]);
              isVisited[1][ny][nx] = true;
            } 
            // 벽이 아니면 그냥 가면 된다.
            else {
              q.push([ny, nx, cnt + 1, false]);
              isVisited[0][ny][nx] = true;
            }
          }
        }
      }
    }
  }

  return -1;
}