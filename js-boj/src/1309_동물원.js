const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  const dp = Array(n + 1).fill(0);
  dp[0] = 1;
  dp[1] = 3;

  for(let i = 2; i <= n; i++) {
    dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901;
  }

  return dp[n];
}