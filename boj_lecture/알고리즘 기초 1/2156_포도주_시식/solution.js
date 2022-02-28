const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(+input);
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  let ans = arr[0];
  const dp = Array.from({ length: 2 }, () => [...arr]);

  for(let i = 1; i < n; i++) {
    dp[0][i] += dp[1][i-1];
    dp[1][i] += Math.max(dp[0][i-2] || 0, dp[1][i-2] || 0, dp[0][i-3] || 0, dp[1][i-3] || 0);
    ans = Math.max(ans, dp[0][i], dp[1][i]);
  }

  console.log(ans);
});