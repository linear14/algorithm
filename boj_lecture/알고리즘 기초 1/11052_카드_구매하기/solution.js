const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let p;
let dp;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    p = input.split(' ').map(i => +i);
    dp = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  for(let i = 1; i < n; i++) {
    for(let j = i; j > 0; j--) {
      dp[i] = Math.max(dp[i], dp[i-j] + p[j-1]);
    }
  }
  console.log(dp[n-1]);
});