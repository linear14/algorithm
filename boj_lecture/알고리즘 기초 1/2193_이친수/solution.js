const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let dp;
rl.on('line', (input) => {
  n = +input;
  dp = Array.from({ length: n + 1 }, () => Array(2).fill(BigInt(0)));
  rl.close();
}).on('close', () => {
  dp[1] = [BigInt(0), BigInt(1)];
  for(let i = 2; i <= n; i++) {
    dp[i] = [BigInt(dp[i-1][0] + dp[i-1][1]), BigInt(dp[i-1][0])];
  }
  console.log(BigInt(dp[n][0] + dp[n][1]).toString());
});