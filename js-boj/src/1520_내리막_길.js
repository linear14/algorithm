const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

rl.on('line', (input) => {
  if(!m) [m, n] = input.split(' ').map(i => +i);
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === m) rl.close();
  }
  
}).on('close', () => {
  console.log(sol());
})

let m, n;
const arr = [];
const d = [[-1, 0], [1, 0], [0, -1], [0, 1]];

// const sol = () => {
//   const dp = Array.from({ length: m }, () => Array(n).fill(null));
//   const isVisited = Array.from({ length: m }, () => Array(n).fill(false));
//   isVisited[0][0] = true;

//   const dfs = (y, x) => {
//     if(y === m - 1 && x === n - 1) return 1;
//     if(dp[y][x] === null) {
//       dp[y][x] = 0;
//       for(let i = 0; i < 4; i++) {
//         const [ny, nx] = [y + d[i][0], x + d[i][1]];
//         if(nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisited[ny][nx] && arr[ny][nx] < arr[y][x]) {
//           isVisited[ny][nx] = true;
//           dp[y][x] += dfs(ny, nx);
//           isVisited[ny][nx] = false;
//         }
//       }
//     }
//     return dp[y][x];
//   }
//   return dfs(0, 0);
// }

const sol = () => {
  const dp = Array.from({ length: m }, () => Array(n).fill(null));

  const dfs = (y, x) => {
    if(y === m - 1 && x === n - 1) return 1;

    if(dp[y][x] === null) {
      dp[y][x] = 0;
      for(let i = 0; i < 4; i++) {
        const [ny, nx] = [y + d[i][0], x + d[i][1]];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[ny][nx] < arr[y][x]) {
          dp[y][x] += dfs(ny, nx);
        }
      }
    }
    return dp[y][x];
  }
  return dfs(0, 0);
}