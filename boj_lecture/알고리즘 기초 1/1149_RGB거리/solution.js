const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const dp = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    dp.push(input.split(' ').map(i => +i));
    if(dp.length === n) rl.close();
  }
}).on('close', () => {
  for(let i = 1; i < n; i++) {
    dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
    dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
    dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
  }

  console.log(Math.min(...dp[n-1]));
});