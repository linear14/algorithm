const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

rl.on('line', (input) => {
  [n, k] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  console.log(sol());
})

let n, k;

// const sol = () => {
//   const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(0));
//   for(let i = 0; i <= n; i++) {
//     for(let j = 1; j <= k; j++) {
//       if(i === 0 || j === 1) {
//         dp[i][j] = 1;
//       }
//       else {
//         let sum = 0;
//         for(let s = 0; s <= n; s++) {
//           sum += (dp[s][j - 1]) % 1000000000;
//         }
//         dp[i][j] = sum % 1000000000;
//       }
//     }
//   }
//   return dp[n][k];
// }

const sol = () => {
  const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(0));
  for(let i = 0; i <= n; i++) {
    for(let j = 1; j <= k; j++) {
      if(i === 0 || j === 1) {
        dp[i][j] = 1;
      }
      else {
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
      }
    }
  }
  return dp[n][k];
}